package com.example.MongoDemo.repository;

import com.example.MongoDemo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface BookRepository extends MongoRepository<Book,String> {
    @Query("{'author.address' : {$in:[?0]}}")
    public abstract List<Book> getBookByAuthorAddress(String address);
}
