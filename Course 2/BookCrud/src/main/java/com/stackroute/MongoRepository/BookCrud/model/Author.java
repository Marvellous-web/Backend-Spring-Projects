package com.stackroute.MongoRepository.BookCrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    private String authName,address,age;
}
