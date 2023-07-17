package com.stackroute.MongoRepository.CustomerService.repository;

import com.stackroute.MongoRepository.CustomerService.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {

    @Query("{'customerProduct.productDescription' :{$in:[?0]}}")
    public abstract List<Customer> getCustomerByProductDescription(String description);
}
