package com.stackroute.JPA.ProductCrud.service;

import com.stackroute.JPA.ProductCrud.model.Product;

import java.util.List;

public interface ProductService {
    public abstract List<Product> getProduct();
    public abstract Product addProduct(Product product);
    public abstract boolean deleteProduct(String productId);
    public abstract Product getProductById(String productId);
}
