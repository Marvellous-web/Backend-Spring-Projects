package com.stackroute.JPA.ProductCrud.service;

import com.stackroute.JPA.ProductCrud.model.Product;
import com.stackroute.JPA.ProductCrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(String productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product getProductById(String productId) {
        if (productRepository.findById(productId).isPresent()){
            return productRepository.findById(productId).get();
        }
        return null;
    }
}
