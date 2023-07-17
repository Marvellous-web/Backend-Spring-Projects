package com.stackroute.ProductApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor@Data

public class Product {
    private int price,stock;
    private String prodId,prodName;

}
