package com.stackroute.JPA.ProductCrud.repository;

import com.stackroute.JPA.ProductCrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
