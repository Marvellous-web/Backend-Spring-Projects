package org.example.Config;

import org.example.Model.Department;
import org.example.Model.Employee;
import org.springframework.context.annotation.Bean;

public class EmployeeConfigBean {
    @Bean("Employee")
    public Employee getAllEmployee(){
        Employee employee=new Employee();
        employee.setAddress("112 Rajiv Nagar");
        employee.setEmp_id(101);
        employee.setEmp_name("Ramma");
//        employee.setDepartment(new Department(12,"IT"));
        return employee;
    }
    @Bean
    public Department getDepart(){
        return new Department(12,"IT");
    }

}
