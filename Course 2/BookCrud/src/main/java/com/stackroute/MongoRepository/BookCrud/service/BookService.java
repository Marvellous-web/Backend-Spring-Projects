package com.stackroute.MongoRepository.BookCrud.service;

import com.stackroute.MongoRepository.BookCrud.exception.BookAlreadyExistException;
import com.stackroute.MongoRepository.BookCrud.exception.BookNotFoundException;
import com.stackroute.MongoRepository.BookCrud.model.Book;

import java.util.List;

public interface BookService {
    public abstract Book addBooks(Book book)throws BookAlreadyExistException;

    public abstract List<Book> getAllBook();

    public abstract boolean deleteBook(String bkId)throws BookNotFoundException;

    public abstract Book updateBook(Book book)throws BookNotFoundException;

    public abstract Book getBookById(String bkId)throws BookNotFoundException;

    public abstract List<Book> getBookByAddress(String address);
}
