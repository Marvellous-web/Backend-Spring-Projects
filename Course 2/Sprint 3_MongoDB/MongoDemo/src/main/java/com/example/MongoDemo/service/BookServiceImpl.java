package com.example.MongoDemo.service;

import com.example.MongoDemo.exceptions.BookAlreadyFoundException;
import com.example.MongoDemo.exceptions.BookNotFoundException;
import com.example.MongoDemo.model.Book;
import com.example.MongoDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBook(Book book) throws BookAlreadyFoundException {
        if (bookRepository.findById(book.getBook_id()).isEmpty())
        {
            return bookRepository.save(book);
        }
        throw new BookAlreadyFoundException();


    }

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public boolean deleteBookById(String id) throws BookNotFoundException {
        if(bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        else
            throw new BookNotFoundException();


    }

    @Override
    public Book updateBook(Book book,String id) throws BookNotFoundException{
        if(bookRepository.findById(id).isPresent())
        {
            return bookRepository.save(book);


        }
        throw new BookNotFoundException();
    }

    @Override
    public List<Book> getBookByAuthorAddress(String address) {
        return bookRepository.getBookByAuthorAddress(address);
    }
}
