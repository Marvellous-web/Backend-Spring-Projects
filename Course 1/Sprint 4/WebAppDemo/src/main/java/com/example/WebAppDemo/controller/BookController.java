package com.example.WebAppDemo.controller;

import com.example.WebAppDemo.model.Book;
import com.example.WebAppDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
            private BookService bookService;
//    List<Book> bookArr=new ArrayList<Book>();
    @GetMapping("/getbooks")
    public ResponseEntity<?> getBook() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);

    }
//    @GetMapping("/getCal/{val1}/{val2}")
//    public ResponseEntity<?> Calculate(@PathVariable int val1,@PathVariable int val2){
//        int result=val2+val1;
//        return new ResponseEntity<>("result",HttpStatus.OK);
//    }
//    @GetMapping("/getBook")
//    public ResponseEntity<?> getBook(){
//        return new ResponseEntity<>(bookArr,HttpStatus.OK);
//    }
    @PostMapping("/saveBook")
    public ResponseEntity<?> addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
        return new ResponseEntity<>("Book saved",HttpStatus.OK);
    }


}
