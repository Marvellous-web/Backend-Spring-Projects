package com.example.H2Demo.controller;

import com.example.H2Demo.model.Book;
import com.example.H2Demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<?> getBook(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }
    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
    }
    @PutMapping("/updateBookById/{id}")
    public ResponseEntity<?> updateByID(@PathVariable String id,@RequestBody Book book){
        return new ResponseEntity<>(bookService.updatebyId(book,id),HttpStatus.OK);
    }
}
