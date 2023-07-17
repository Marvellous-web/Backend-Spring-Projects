package com.example.MongoDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor@NoArgsConstructor@Data @Document
public class Book {
    @Id
    private String book_id;
    private String name,subject;
    private int price,stock;
    private Author author;


}
