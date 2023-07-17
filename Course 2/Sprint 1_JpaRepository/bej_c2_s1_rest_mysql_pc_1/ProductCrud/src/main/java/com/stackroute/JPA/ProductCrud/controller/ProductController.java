package com.stackroute.JPA.ProductCrud.controller;

import com.stackroute.JPA.ProductCrud.model.Product;
import com.stackroute.JPA.ProductCrud.repository.ProductRepository;
import com.stackroute.JPA.ProductCrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    //http://localhost:4444/getProduct       [GET]
    @GetMapping("/getProduct")
    public ResponseEntity<?> getProduct(){

        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    //http://localhost:4444/addProduct       [POST]
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
    }

    //http://localhost:4444/delete-product-by-id/{productId}      [DELETE]
    @DeleteMapping("/delete-product-by-id/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.OK);
    }

    //http://localhost:4444/get-product-by-id/{productId}        [GET]
    @GetMapping("/get-product-by-id/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String productId){
        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }
}
