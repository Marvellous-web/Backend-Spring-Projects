package com.stackroute.bej.product.service;

import com.stackroute.bej.product.model.Customer;
import com.stackroute.bej.product.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@
public class ProductServiceImpl implements ProductService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return ;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public List<Customer> getCustomerSamsung(String samsung) {
        return null;
    }
}
