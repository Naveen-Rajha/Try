package com.company;
class Display {
    void showdata(String s){
        System.out.println("Printing "+s);
    }
}
class Test extends Thread{
    Display d ;
    String data;
    Test(String data,Display d){
        this.data = data;
        this.d = d;
    }
    public void run(){
       synchronized (d){System.out.println("Starting "+Thread.currentThread().getName());
        d.showdata(data);
        System.out.println("Ending "+Thread.currentThread().getName());}
    }
}
class Tap extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("Daemon Running");
        }
    }
}
public class Thread1 {
    public static void main(String arg[])throws InterruptedException{
        Display d = new Display();
        Test t1 = new Test("Hello",d);
        t1.start();
        Test t2 = new Test("I am ",d);
        t2.start();
        Test t3 = new Test("Naveen",d);
        t3.start();
        Tap t4 = new Tap();
        Tap t5 = new Tap();
        t4.setDaemon(true);
        t4.start();
        t5.setDaemon(true);
        t5.start();
    }
}
