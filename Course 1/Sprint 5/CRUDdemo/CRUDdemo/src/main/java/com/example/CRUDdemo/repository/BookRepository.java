package com.example.CRUDdemo.repository;

import com.example.CRUDdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,String> {



}