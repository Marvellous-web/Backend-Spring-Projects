package com.stackroute.MongoRepository.BookCrud.repository;

import com.stackroute.MongoRepository.BookCrud.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    //insert()
    @Query("{'author.address' :{$in:[?0]}}")
    public abstract List<Book> getBookByAuthorAddress(String address);
}
