package com.stackroute.MongoRepository.CustomerService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Customer {
    @Id
    private String customerId;
    private String customerName,customerPhoneNo;
    private Product customerProduct;
}
