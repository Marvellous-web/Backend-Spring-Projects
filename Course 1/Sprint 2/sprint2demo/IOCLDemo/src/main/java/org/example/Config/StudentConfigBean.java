package org.example.Config;

import org.example.Model.Student;
import org.springframework.context.annotation.Bean;

public class StudentConfigBean {

    @Bean("student1")
    public Student getStudentObject(){
        Student s1=new Student();
        s1.setM1(25);
        s1.setM2(26);
        s1.setM3(27);
        return s1;
    }
    @Bean("student2")
    public Student getStudentObject1(){
        Student s2=new Student(60,70,80);

        return s2;
    }

}
