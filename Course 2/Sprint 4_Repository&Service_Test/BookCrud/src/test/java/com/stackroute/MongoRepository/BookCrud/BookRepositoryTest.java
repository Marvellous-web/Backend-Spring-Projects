package com.stackroute.MongoRepository.BookCrud;

//import com.mongodb.DuplicateKeyException;
import com.stackroute.MongoRepository.BookCrud.model.Author;
import com.stackroute.MongoRepository.BookCrud.model.Book;
import com.stackroute.MongoRepository.BookCrud.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataMongoTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    private Book book;
    private Author author;

    @BeforeEach
    //define setup/init
    public void setup(){
        author=new Author("jon steek","pune","30");
        book=new Book("BK001","C++","Programing",author,500,20);
    }

    @AfterEach
    //define clear/destroy
    private void clean(){
        book=null;
        author=null;
        bookRepository.deleteAll();
    }

    //write the test cases for MongoRepository methods
    @Test
    //success test case for insert() method
    public void testSuccessInsertMethod(){
        bookRepository.insert(book); //inserting a book record
        //get the book record from database
        Book result=bookRepository.findById(book.getBkId()).get();
        System.out.println(book.equals(result)); //comparing the book and result object
        assertEquals(true,book.equals(result));
    }

    @Test
    //failure test case for insert() method
    public void testFailureInsertMethode(){
        bookRepository.insert(book); //inserting record
        assertThrows(DuplicateKeyException.class,()->bookRepository.insert(book));
        //if we try to insert duplicate id then insert()method throws the exception
    }

    @Test
    //test case fpt deleteById() method
    public void testDeleteMethod(){
        //first insert the book record
        bookRepository.insert(book);
        //then try to delete the record
        bookRepository.deleteById(book.getBkId());
        assertEquals(true,bookRepository.findById(book.getBkId()).isEmpty());
        //get the book id
    }
    @Test
    //test case for update method
    public void testUpdateMethod(){

        bookRepository.insert(book);
        Book result=bookRepository.findById(book.getBkId()).get();
        book.setName("Stories");
        bookRepository.save(book);
        assertEquals(book,bookRepository.findById("BK001").get());

    }

    @Test
    public void getAllBook()
    {
//        bookRepository.insert(book);
//        book.setBkId("BK002");
//        bookRepository.insert(book);
//        List<Book> books=bookRepository.findAll();
//        assertEquals(2,books.size());
        bookRepository.save(book);
        Book book1=new Book("BK002","Java","Coding",
                new Author("ABC","Delhi","40"),500, 55);
        bookRepository.save(book1);
        assertIterableEquals(Arrays.asList(book,book1),bookRepository.findAll());
    }
}
