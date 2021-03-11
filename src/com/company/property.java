package com.company;

import java.util.Comparator;
import java.util.TreeSet;

class Customer {
    int id;
    String name;
    Customer(int id,String name){
        this.id = id;
        this.name = name;
    }
}
class Comparethem implements Comparator<Customer>{
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class property {
    public static void main(String arg[]){
        TreeSet<Customer> ts = new TreeSet<>(new Comparethem());
        Customer c1 = new Customer(1,"aravind");
        Customer c2 = new Customer(2,"naveen");
        Customer c3 = new Customer(3,"george");
        Customer c4 = new Customer(4,"sudha");
        ts.add(c1);
        ts.add(c2);
        ts.add(c3);
        ts.add(c4);
        for(Customer c:ts )
        System.out.println(c.id+" "+c.name);


    }
}
