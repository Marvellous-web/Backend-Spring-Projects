package org.example;

public class Calculator {
    public int add(int x,int y){
        return x+y;
    }
    public int sub(int x,int y){
        return x-y;
    }
    public int mul(int x,int y){
        return x*y;
    }
    public int div(int x,int y){
        if(y==0){
            throw  new ArithmeticException();
        }
        else {
            return  x/y;
        }
    }
}