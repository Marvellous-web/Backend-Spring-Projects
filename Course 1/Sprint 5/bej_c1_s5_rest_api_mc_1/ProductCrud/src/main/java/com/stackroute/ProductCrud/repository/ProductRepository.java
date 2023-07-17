package com.stackroute.ProductCrud.repository;

import com.stackroute.ProductCrud.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,String> {

}
