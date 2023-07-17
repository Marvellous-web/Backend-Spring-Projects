package com.stackroute.MongoRepository.CustomerService.service;

import com.stackroute.MongoRepository.CustomerService.exception.CustomerAlreadyExistException;
import com.stackroute.MongoRepository.CustomerService.exception.CustomerNotFoundException;
import com.stackroute.MongoRepository.CustomerService.model.Customer;

import java.util.List;

public interface CustomerService {
    public abstract Customer addCustomer(Customer customer)throws CustomerAlreadyExistException;

    public abstract List<Customer> getAllCustomer();

    public abstract boolean deleteCustomer(String customerId)throws CustomerNotFoundException;

    public abstract List<Customer> getCustomerByDescription(String description)throws CustomerNotFoundException;

    public abstract Customer getCustomerById(String custId)throws CustomerNotFoundException;

    public abstract Customer updateCustomerById(Customer customer,String custId)throws CustomerNotFoundException;

}
