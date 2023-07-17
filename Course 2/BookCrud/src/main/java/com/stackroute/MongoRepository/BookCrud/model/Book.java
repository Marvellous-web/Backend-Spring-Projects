package com.stackroute.MongoRepository.BookCrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Book {
    @Id
    private String bkId;
    private String name,subject;
    private Author author;
    private int price,stock;
}
