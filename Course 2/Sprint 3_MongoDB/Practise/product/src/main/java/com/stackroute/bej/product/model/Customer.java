package com.stackroute.bej.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor @Document
public class Customer {
    @Id
    private String cust_id;
    private String name,number;
    private Product product;

}
