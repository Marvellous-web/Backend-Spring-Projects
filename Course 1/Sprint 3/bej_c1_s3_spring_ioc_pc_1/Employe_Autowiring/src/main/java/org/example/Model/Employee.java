package org.example.Model;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    private int emp_id;
    private String emp_name,address;
    @Autowired
    private  Department department;

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
                '}';
    }
}
