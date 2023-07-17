package org.example;

import java.util.ArrayList;
import java.util.List;

public class Operation {
    public int add(int a,int b)
    {
        return a+b;
    }
    public List<Integer> getLeapYear(int from,int to){
        List<Integer> leaps=new ArrayList<Integer>();
        for(int i=from;i<=to;i++)
        {
            if((i%400==0)|| (i%100!=0 && i%4==0))
            {
                leaps.add(i);
            }
        }
        System.out.println(leaps);
        return leaps;
    }
    public int div(int a,int b){
        if(b==0)
        {
            throw new ArithmeticException();
        }
        else return a/b;
    }

    public String getResult(int... marks){
        String result="Pass";
        for(int m:marks)
        {
            if(m<50)
            {
                result="Fail";
            }
        }
        return result;
    }
}
