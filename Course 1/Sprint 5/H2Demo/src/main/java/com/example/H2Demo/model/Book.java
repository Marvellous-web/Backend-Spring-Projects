package com.example.H2Demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id
    private String id;
    private String book_name,subject,author;
    private int price,stock;
}
