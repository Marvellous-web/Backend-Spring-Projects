package org.example;

import org.example.Config.BookBeanConfig1;
import org.example.Config.BookBeanConfig2;
import org.example.Config.BookBeanConfig3;


import org.example.model1.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //Property Autowiring
        ApplicationContext context= new AnnotationConfigApplicationContext(BookBeanConfig1.class);
        System.out.println("Property Autowiring");
        Book b1=(Book)context.getBean("Book");
        System.out.println(b1);
//        //Setter Autowiring
//        ApplicationContext context1= new AnnotationConfigApplicationContext(BookBeanConfig2.class);
//        System.out.println("Setter Autowiring");
//        Book b11=(Book)context1.getBean("Book1");
//        System.out.println(b11);
////        //Constructor Autowiring
////        ApplicationContext context3=new AnnotationConfigApplicationContext(BookBeanConfig3.class);
////        System.out.println("Constructor Autowiring");
////        Book b111=(Book)context3.getBean("Book3");
////        System.out.println(b111);


    }
}
