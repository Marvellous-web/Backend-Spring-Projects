package com.stackroute.ProductCrud.controller;

import com.stackroute.ProductCrud.model.Product;
import com.stackroute.ProductCrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    //http://localhost:8888/getProducts     [GET]
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProduct(){
        return new ResponseEntity<>(productService.getProduct(), HttpStatus.OK);
    }

    //http://localhost:8888/addProducts     [POST]
    @PostMapping("/addProducts")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
    }


}
