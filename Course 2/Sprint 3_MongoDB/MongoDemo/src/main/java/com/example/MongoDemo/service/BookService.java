package com.example.MongoDemo.service;

import com.example.MongoDemo.exceptions.BookAlreadyFoundException;
import com.example.MongoDemo.exceptions.BookNotFoundException;
import com.example.MongoDemo.model.Book;

import java.util.List;

public interface BookService {
    public abstract Book addBook(Book book) throws BookAlreadyFoundException;
    public abstract List<Book> getBooks();
    public abstract boolean deleteBookById(String id) throws BookNotFoundException;
    public abstract Book updateBook(Book book,String id) throws BookNotFoundException;
    public abstract List<Book> getBookByAuthorAddress(String address);

}
