package com.example.WebAppDemo.service;

import com.example.WebAppDemo.model.Book;

import java.util.List;

public interface BookService {
    public abstract List<Book> getBooks();
    public abstract void addBook(Book book);
}
