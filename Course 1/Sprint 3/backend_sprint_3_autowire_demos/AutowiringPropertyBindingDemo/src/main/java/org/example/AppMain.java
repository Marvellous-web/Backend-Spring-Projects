package org.example;

import org.example.Config.BookBeanConfig1;
import org.example.Config.BookBeanConfig2;
import org.example.Config.BookBeanConfig3;


import org.example.model2.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class AppMain
{
    public static void main( String[] args )
    {


        //Setter Autowiring
        ApplicationContext context1= new AnnotationConfigApplicationContext(BookBeanConfig2.class);
        System.out.println("Setter Autowiring");
        Book b11=(Book)context1.getBean("Book1");
        System.out.println(b11);



    }
}
