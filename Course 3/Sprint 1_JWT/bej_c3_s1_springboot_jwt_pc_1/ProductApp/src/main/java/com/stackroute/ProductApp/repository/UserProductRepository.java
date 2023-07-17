package com.stackroute.ProductApp.repository;

import com.stackroute.ProductApp.model.Product;
import com.stackroute.ProductApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserProductRepository extends MongoRepository<User,String> {

//    @Query("select s from Product s where s.emailId=?1")
//    public abstract Product findBEmailIdAndPassword(String id,String pass);



}
