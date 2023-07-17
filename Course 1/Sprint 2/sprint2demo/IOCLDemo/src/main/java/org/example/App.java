package org.example;

import org.example.Config.StudentConfigBean;
import org.example.Model.Student;
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
        ApplicationContext context=new AnnotationConfigApplicationContext(StudentConfigBean.class);
        Student a=(Student)context.getBean("student1");
        Student b=context.getBean("student2",Student.class);
        System.out.println(a);
        System.out.println(b);




    }
}
