package com.company;
class Product{
    private int count;
    boolean setValue = false;
    public synchronized void setCount(int count){
        if(setValue){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count = count;
        System.out.println("Put Count"+count);
        setValue = true;
        notify();
    }
    public synchronized void getCount(){
        if (!setValue){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get Count"+count);
        setValue = false;
        notify();
    }
}
class Produce extends Thread{
    Product p;
    Produce(Product p){
        this.p=p;
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            p.setCount(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consume extends Thread{
    Product p;
    Consume(Product p){
        this.p=p;
    }

    @Override
    public void run() {
        while(true){
            p.getCount();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Wait {
    public static void main(String arg[]){
        Product p = new Product();
        Consume c = new Consume(p);
        Produce pr = new Produce(p);
        pr.start();
        c.start();
    }
}
