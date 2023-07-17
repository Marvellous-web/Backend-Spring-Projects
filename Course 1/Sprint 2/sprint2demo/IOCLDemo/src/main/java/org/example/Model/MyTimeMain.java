package org.example.Model;

import org.example.Config.MyTimeConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTimeMain {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(MyTimeConfigBean.class);
        MyTime time1=(MyTime)context.getBean("Time1");
        System.out.println(time1);
        MyTime time2=context.getBean("Time2", MyTime.class);
        System.out.println(time2);
    }
}
