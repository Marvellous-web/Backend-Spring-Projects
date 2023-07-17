package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Operation operation=new Operation();
        System.out.println(operation.add(5,7));
        System.out.println(operation.getLeapYear(1992,2000));
    }
}