package com.example.MongoDemo.controller;

import com.example.MongoDemo.exceptions.BookAlreadyFoundException;
import com.example.MongoDemo.exceptions.BookNotFoundException;
import com.example.MongoDemo.model.Book;
import com.example.MongoDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) throws BookAlreadyFoundException
    {


        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }
    @GetMapping("/getBook")
    public ResponseEntity<?> getBook()
    {
        return new ResponseEntity<>(bookService.getBooks(),HttpStatus.OK);
    }
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<?> deleteBookByID(@PathVariable String id) throws BookNotFoundException
    {
        return new ResponseEntity<>(bookService.deleteBookById(id),HttpStatus.OK);
    }
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book,@PathVariable String id) throws BookNotFoundException
    {
        return new ResponseEntity<>(bookService.updateBook(book,id),HttpStatus.OK);
    }
    @GetMapping("/getBookByAuthorAddress/{address}")
    public ResponseEntity<?> getBookByAuthor(@PathVariable String address)
    {
        return new ResponseEntity<>(bookService.getBookByAuthorAddress(address),HttpStatus.OK);
    }

}
