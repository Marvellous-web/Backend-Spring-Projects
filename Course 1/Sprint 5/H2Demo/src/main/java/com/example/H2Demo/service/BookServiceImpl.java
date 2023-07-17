package com.example.H2Demo.service;

import com.example.H2Demo.model.Book;
import com.example.H2Demo.repository.BookRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private  BookRepos bookRepos;
    @Override
    public Book addBook(Book book) {
        return bookRepos.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepos.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepos.save(book);
    }

    @Override
    public boolean deleteBook(String id) {
        bookRepos.deleteById(id);
        return true;
    }

    @Override
    public Book updatebyId(Book book, String id) {
        if(bookRepos.findById(id).isPresent())
        {
            return bookRepos.save(book);
        }
        return null;
    }
}
