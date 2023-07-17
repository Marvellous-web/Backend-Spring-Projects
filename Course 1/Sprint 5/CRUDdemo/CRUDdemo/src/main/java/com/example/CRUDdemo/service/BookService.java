package com.example.CRUDdemo.service;

import com.example.CRUDdemo.model.Book;
import com.example.CRUDdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    public abstract Book addBook(Book book);
    public abstract List<Book> getAllBooks();


}
