package org.example;

import org.example.Config.EmployeeConfigBean;
import org.example.Model.Employee;
import org.springframework.beans.factory.BeanFactory;
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
//        ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfigBean.class);
        // or
        BeanFactory context=new AnnotationConfigApplicationContext(EmployeeConfigBean.class);
        Employee e1=(Employee)context.getBean("Employee") ;
        System.out.println(e1);

    }
}
