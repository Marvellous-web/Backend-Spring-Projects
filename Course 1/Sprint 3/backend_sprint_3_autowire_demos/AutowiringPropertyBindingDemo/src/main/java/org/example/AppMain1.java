package org.example;

import org.example.Config.BookBeanConfig1;
import org.example.Config.BookBeanConfig2;
import org.example.Config.BookBeanConfig3;


import org.example.model3.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class AppMain1
{
    public static void main( String[] args )
    {


        //Constructor Autowiring
        ApplicationContext context3=new AnnotationConfigApplicationContext(BookBeanConfig3.class);
        System.out.println("Constructor Autowiring");
        Book b111=(Book)context3.getBean("Book3");
        System.out.println(b111);


    }
}
