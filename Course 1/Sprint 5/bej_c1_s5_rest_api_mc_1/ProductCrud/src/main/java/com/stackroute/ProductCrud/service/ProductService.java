package com.stackroute.ProductCrud.service;

import com.stackroute.ProductCrud.model.Product;
import com.stackroute.ProductCrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService {
    public abstract List<Product> getProduct();
    public abstract Product addProduct(Product product);
}
