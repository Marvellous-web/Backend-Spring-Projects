package org.example.Config;

import org.example.Model.MyTime;
import org.springframework.context.annotation.Bean;

public class MyTimeConfigBean {
    @Bean("Time1")
    public MyTime getTime(){
        MyTime myTime=new MyTime();
        myTime.setHr(12);
        myTime.setMin(15);
        myTime.setSec(50);
        return myTime;
    }
    @Bean("Time2")
    public MyTime getTime1(){
        MyTime myTime1=new MyTime(13,15,50);
        return myTime1;

    }
}
