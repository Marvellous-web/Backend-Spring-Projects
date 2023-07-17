package com.stackroute.bej.product.repository;

import com.stackroute.bej.product.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
