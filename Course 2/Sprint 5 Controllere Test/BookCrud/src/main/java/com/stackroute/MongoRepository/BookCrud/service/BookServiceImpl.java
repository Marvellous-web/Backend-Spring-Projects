package com.stackroute.MongoRepository.BookCrud.service;

import com.stackroute.MongoRepository.BookCrud.exception.BookAlreadyExistException;
import com.stackroute.MongoRepository.BookCrud.exception.BookNotFoundException;
import com.stackroute.MongoRepository.BookCrud.model.Book;
import com.stackroute.MongoRepository.BookCrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBooks(Book book) throws BookAlreadyExistException {
        if (bookRepository.findById(book.getBkId()).isEmpty()){
            return bookRepository.save(book);
        }
        else {
            throw new BookAlreadyExistException();
        }
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(String bkId)throws BookNotFoundException {
        if (bookRepository.findById(bkId).isPresent()){
            bookRepository.deleteById(bkId);
            return true;
        }
        throw new BookNotFoundException();
    }

    @Override
    public Book updateBook(Book book)throws BookNotFoundException{
        if (bookRepository.findById(book.getBkId()).isPresent()){
            return bookRepository.save(book);
        }
        else {
            throw new BookNotFoundException();
        }
    }

    @Override
    public Book getBookById(String bkId)throws BookNotFoundException {
        if (bookRepository.findById(bkId).isPresent()){
            return bookRepository.findById(bkId).get();
        }
        else {
            throw new BookNotFoundException();
        }
    }

    @Override
    public List<Book> getBookByAddress(String address) {
        return bookRepository.getBookByAuthorAddress(address);
    }
}
