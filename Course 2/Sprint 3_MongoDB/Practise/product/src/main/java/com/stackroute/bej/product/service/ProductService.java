package com.stackroute.bej.product.service;

import com.stackroute.bej.product.model.Customer;

import java.util.List;

public interface ProductService {
    public abstract List<Customer> getAllCustomer();
    public abstract Customer addCustomer(Customer customer);
    public abstract boolean deleteCustomer(String id);
    public abstract List<Customer> getCustomerSamsung(String samsung);
}
