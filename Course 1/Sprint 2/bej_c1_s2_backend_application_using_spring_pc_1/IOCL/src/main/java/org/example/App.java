package org.example;

import org.example.Config.ProductConfigBean;
import org.example.Model.Product;
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
        System.out.println( "Hello World!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(ProductConfigBean.class);
        Product p1=(Product)context.getBean("Product1");
        System.out.println(p1);
        Product p2=context.getBean("Product2", Product.class);
        System.out.println(p2);
    }
}
