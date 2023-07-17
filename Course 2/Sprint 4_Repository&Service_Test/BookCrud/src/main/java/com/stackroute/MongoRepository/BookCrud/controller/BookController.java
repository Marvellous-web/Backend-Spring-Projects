package com.stackroute.MongoRepository.BookCrud.controller;

import com.stackroute.MongoRepository.BookCrud.exception.BookAlreadyExistException;
import com.stackroute.MongoRepository.BookCrud.exception.BookNotFoundException;
import com.stackroute.MongoRepository.BookCrud.model.Book;
import com.stackroute.MongoRepository.BookCrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    //http://localhost:9999/addBook     [POST]
    @PostMapping("/addBook")
    public ResponseEntity<?> addBooks(@RequestBody Book book) throws BookAlreadyExistException {
        try {
            return new ResponseEntity<>(bookService.addBooks(book), HttpStatus.OK);
        }
        catch (BookAlreadyExistException ex){
            throw new BookAlreadyExistException();
        }

    }

    //http://localhost:9999/getAllBook    [GET]
    @GetMapping("/getAllBook")
    public ResponseEntity<?> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
    }

    //http://localhost:9999/delete-book-by-id/{bkId}    [DELETE]
    @DeleteMapping("/delete-book-by-id/{bkId}")
    public ResponseEntity<?> deleteBook(@PathVariable String bkId) throws BookNotFoundException {
        try {
            return new ResponseEntity<>(bookService.deleteBook(bkId),HttpStatus.OK);
        }
        catch (BookNotFoundException ex){
            throw new BookNotFoundException();
        }

    }

    //http://localhost:9999/updateBook    [UPDATE]
    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody Book book) throws BookNotFoundException {
        try {
            return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
        }
        catch (BookNotFoundException ex){
            throw new BookNotFoundException();
        }
    }

    //http://localhost:9999/get-book-by-id/{bkId}       [GET]
    @GetMapping("/get-book-by-id/{bkId}")
    public ResponseEntity<?> getBookById(@PathVariable String bkId) throws BookNotFoundException {
        try {
            return new ResponseEntity<>(bookService.getBookById(bkId),HttpStatus.OK);
        }
        catch (BookNotFoundException ex){
            throw  new BookNotFoundException();
        }
    }

    //http://localhost:9999/get-book-by-address/{address}       [GET]
    @GetMapping("/get-book-by-address/{address}")
    public ResponseEntity<?> getBookByAddress(@PathVariable String address){
        return new ResponseEntity<>(bookService.getBookByAddress(address),HttpStatus.OK);
    }

}
