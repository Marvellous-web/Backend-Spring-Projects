package com.example.H2Demo.service;

import com.example.H2Demo.model.Book;

import java.util.List;

public interface BookService {
    public abstract Book addBook(Book book);
    public abstract List<Book> getAllBooks();
    public abstract Book updateBook(Book book);
    public abstract boolean deleteBook(String id);
    public abstract Book updatebyId(Book book,String id);
}
