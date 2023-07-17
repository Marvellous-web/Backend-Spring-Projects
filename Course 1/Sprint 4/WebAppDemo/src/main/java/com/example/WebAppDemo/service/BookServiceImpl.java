package com.example.WebAppDemo.service;

import com.example.WebAppDemo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
private List<Book> bookMasterData;

public BookServiceImpl(){
    bookMasterData=new ArrayList<Book>();
}
    @Override
    public List<Book> getBooks() {
        return bookMasterData;
    }

    @Override
    public void addBook(Book book) {
    bookMasterData.add(book);

    }
}
