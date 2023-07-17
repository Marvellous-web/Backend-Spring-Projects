package com.example.CRUDdemo.controller;

import com.example.CRUDdemo.model.Book;
import com.example.CRUDdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/getBooks")
    public ResponseEntity<?> getAllBooks(){
        return new ResponseEntity<>( bookService.getAllBooks(),HttpStatus.OK);
    }
    @PostMapping("/addBook")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.OK);
    }
}
