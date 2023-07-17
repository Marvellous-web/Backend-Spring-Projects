package com.stackroute.MongoRepository.CustomerService;


import com.stackroute.MongoRepository.CustomerService.model.Customer;
import com.stackroute.MongoRepository.CustomerService.model.Product;
import com.stackroute.MongoRepository.CustomerService.repository.CustomerRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Product product;

    @BeforeEach
    public void setup(){
        product=new Product("PR01","Mobile","Samsung");
        customer=new Customer("CS001","prateek","8698846149",product);
    }

    @AfterEach
    public void clean(){
        product=null;
        customer=null;
        customerRepository.deleteAll();
    }

    //write the test cases for MongoRepository methods like save(),findById(),deleteById(),..
    @Test
    //success test case for save() method in repository layer
    public void testSaveMethod(){
        customerRepository.save(customer); //insert the record in new database
        Customer result=customerRepository.findById(customer.getCustomerId()).get();
        //get the customer record from database
        System.out.println(result.equals(customer)); //comparing two object using equals() method
        assertEquals(true,customer.equals(result));
    }
    @Test
    //failure test case for save() method in repository layer
    public void testFailureSaveMethod(){
        //if book already present in database with same id then save() method throws the exception
        customerRepository.save(customer); //inserting record
        assertThrows(DuplicateKeyException.class,()->customerRepository.insert(customer));
        //inserting same record but method throws the exception
        //Note: only insert() method throw the exception in mongoRepository
    }

    @Test
    //test case for delete customer
    public void testDeleteByIdMethod(){
        customerRepository.save(customer); //save the record
        customerRepository.deleteById(customer.getCustomerId()); //delete the record by id
        assertEquals(true,customerRepository.findById(customer.getCustomerId()).isEmpty());
        //get the customer id
    }

    @Test
    //test case for findAll(),this method used tho get the all customer list
    public void testFindAllMethod(){
        customerRepository.save(customer);
        Customer customer1=new Customer("CS002","Pooja","8596094586",
                new Product("PR2","Laptop","Dell"));
        customerRepository.save(customer1);
        assertIterableEquals(Arrays.asList(customer,customer1),customerRepository.findAll());
    }

    @Test
    public void testUpdateCustomer(){
        customerRepository.insert(customer);
        Customer result=customerRepository.findById(customer.getCustomerId()).get();
        customer.setCustomerName("Prateek");
        customerRepository.save(customer);
        assertEquals(customer,customerRepository.findById("CS001").get());
    }
}
