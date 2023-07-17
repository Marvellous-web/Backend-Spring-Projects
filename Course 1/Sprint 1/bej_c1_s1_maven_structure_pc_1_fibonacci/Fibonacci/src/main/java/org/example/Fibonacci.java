package org.example;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public List<Integer> getSeries(int x) {
        ArrayList<Integer> fibonacci = new ArrayList<Integer>();
        int n1 = 0, n2 = 1, n3, i, count = 10;


        for (i = 2; i < count; ++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;

            fibonacci.add(n3);

            n1 = n2;
            n2 = n3;
        }
        return fibonacci;
    }
}



//    public static void main(String args[])
//    {
//        int n = 9;
//        System.out.println(fib(n));
//    }

