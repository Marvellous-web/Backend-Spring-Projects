package com.stackroute.MongoRepository.CustomerService.service;

import com.stackroute.MongoRepository.CustomerService.exception.CustomerAlreadyExistException;
import com.stackroute.MongoRepository.CustomerService.exception.CustomerNotFoundException;
import com.stackroute.MongoRepository.CustomerService.model.Customer;
import com.stackroute.MongoRepository.CustomerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer)throws CustomerAlreadyExistException {
        if (customerRepository.findById(customer.getCustomerId()).isEmpty()){
            return customerRepository.save(customer);
        }
        else throw new CustomerAlreadyExistException();
    }

    @Override
    public List<Customer> getAllCustomer(){

        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(String customerId)throws CustomerNotFoundException {
        if (customerRepository.findById(customerId).isPresent()){
            customerRepository.deleteById(customerId);
            return true;
        }
        else throw new CustomerNotFoundException();
    }

    @Override
    public List<Customer> getCustomerByDescription(String description) throws CustomerNotFoundException {
       List<Customer> result= customerRepository.getCustomerByProductDescription(description);
       if (result.size()==0){
           throw new CustomerNotFoundException();
       }
       else {
           return result;
       }
    }

    @Override
    public Customer getCustomerById(String custId)throws CustomerNotFoundException {
        if (customerRepository.findById(custId).isPresent()){
            return customerRepository.findById(custId).get();
        }
        throw new CustomerNotFoundException();
    }

    @Override
    public Customer updateCustomerById(Customer customer, String custId) throws CustomerNotFoundException {
        if (customerRepository.findById(custId).isPresent()){
            return customerRepository.findById(custId).get();
        }
        return null;
    }
}
