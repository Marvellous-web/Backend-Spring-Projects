package com.stackroute.MongoRepository.CustomerService.controller;

import com.stackroute.MongoRepository.CustomerService.exception.CustomerAlreadyExistException;
import com.stackroute.MongoRepository.CustomerService.exception.CustomerNotFoundException;
import com.stackroute.MongoRepository.CustomerService.model.Customer;
import com.stackroute.MongoRepository.CustomerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //http://localhost:1111/addCustomer     [POST]
    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer)throws CustomerAlreadyExistException {
        try {
            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
        }
        catch (CustomerAlreadyExistException ex){
            throw new CustomerAlreadyExistException();
        }
    }

    //http://localhost:1111/getCustomer     [GET]
    @GetMapping("/getCustomer")
    public ResponseEntity<?> getCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
    }

    //http://localhost:1111/delete-customer/{customerId}        [DELETE]
    @DeleteMapping("/delete-customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerId)throws CustomerNotFoundException {
        try {
            return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.OK);
        }
        catch (CustomerNotFoundException ex){
            throw new CustomerNotFoundException();
        }
    }

    //http://localhost:1111/get-customer-by-description/{description}
    @GetMapping("/get-customer-by-description/{description}")
    public ResponseEntity<?> getCustomerByDes(@PathVariable String description) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.getCustomerByDescription(description),HttpStatus.OK);
    }

    @GetMapping("/get-customer-by-id/{custId}")
    public ResponseEntity<?> getCustomerById(@PathVariable String custId)throws CustomerNotFoundException{
        return new ResponseEntity<>(customerService.getCustomerById(custId),HttpStatus.OK);
    }
}
