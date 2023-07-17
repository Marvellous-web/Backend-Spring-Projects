package org.example.Config;

import org.example.Model.Department;
import org.example.Model.Employee;
import org.springframework.context.annotation.Bean;

public class EmployeeConfigBean {
    @Bean("Employee")
    public Employee getAllEmployee(){

        Employee employee=new Employee(101,"Ramma","112 Rajiv Nagar",getDepart());

        return employee;
    }

    public Department getDepart(){
        return new Department(12,"IT");
    }

}
