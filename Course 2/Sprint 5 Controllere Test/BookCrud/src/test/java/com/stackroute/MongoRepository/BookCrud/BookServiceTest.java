package com.stackroute.MongoRepository.BookCrud;

import com.stackroute.MongoRepository.BookCrud.exception.BookAlreadyExistException;
import com.stackroute.MongoRepository.BookCrud.exception.BookNotFoundException;
import com.stackroute.MongoRepository.BookCrud.model.Author;
import com.stackroute.MongoRepository.BookCrud.model.Book;
import com.stackroute.MongoRepository.BookCrud.repository.BookRepository;
import com.stackroute.MongoRepository.BookCrud.service.BookServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock //this is for dependency
    private BookRepository bookRepository;
    @InjectMocks //this is for dependent
    private BookServiceImpl bookService;

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
    public void clean(){
        book=null;
        author=null;
    }
    //test cases for service layer
    @Test
    //success test case for addBook() method
    public void testAddBookSuccess() throws BookAlreadyExistException {
        //if repository call findById() method then return the empty optional object
        //if repository call save() method then return the book object
        when(bookRepository.findById(book.getBkId())).thenReturn(Optional.ofNullable(null));
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book,bookService.addBooks(book));
        verify(bookRepository,times(1)).findById(book.getBkId());
        //verify how many times call the findById() method in repo.
        verify(bookRepository,times(1)).save(book);
        //verify how many times call the save method in repo.
    }

    @Test
    //test case for failure addBook() method
     public void testAddBookFailure(){
        //if repo call the findById() method then return the optional obj with book
        when(bookRepository.findById(book.getBkId())).thenReturn(Optional.of(book));
        assertThrows(BookAlreadyExistException.class,()->bookService.addBooks(book));
        //verify, how many times call the save and findById method
        verify(bookRepository,times(1)).findById(book.getBkId());
        verify(bookRepository,times(0)).save(book);
    }

    @Test
     //test cases for delete the book
      public void testDeleteBookSuccess() throws BookNotFoundException {
        when(bookRepository.findById(book.getBkId())).thenReturn(Optional.of(book));
        boolean result=bookService.deleteBook(book.getBkId());
        assertEquals(true,result);
        verify(bookRepository,times(1)).findById(book.getBkId());
        verify(bookRepository,times(1)).deleteById(book.getBkId());
    }

    @Test
    public void testDeleteBookFailure(){
        when(bookRepository.findById(book.getBkId())).thenReturn(Optional.ofNullable(null));
        assertThrows(BookNotFoundException.class,()->bookService.deleteBook(book.getBkId()));
        verify(bookRepository,times(1)).findById(book.getBkId());
        verify(bookRepository,times(0)).deleteById(book.getBkId());
    }

    @Test
    public void testUpdateBookSuccess() throws BookNotFoundException {
        when(bookRepository.findById(book.getBkId())).thenReturn(Optional.ofNullable(null));
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book,bookService.updateBook(book));
        verify(bookRepository,times(1)).findById(book.getBkId());
        verify(bookRepository,times(1)).save(book);
    }

    @Test
    public void testUpdateBookFailure(){
        when(bookRepository.findById(book.getBkId())).thenReturn(Optional.of(book));
        assertThrows(BookNotFoundException.class,()->bookService.updateBook(book));
        verify(bookRepository,times(1)).findById(book.getBkId());
        verify(bookRepository,times(0)).save(book);
    }

    @Test
    public void testGetAllBook()  {
    Book result=new Book("BK009","C++","Coding",new Author("ABC","Pune","30"),
            400,45);
    /*
    //when repo.findall(): return [b1,b2]
    assert.....( [b1,b2], service.getall());
     */
   when(bookRepository.findAll()).thenReturn(List.of(book,result));
    assertIterableEquals(Arrays.asList(book,result),bookService.getAllBook());
    verify(bookRepository,times(1)).findAll();
    }

    @Test
    public void testGetBookByAddress(){
        Book result1=new Book("BK008","C++","Coding",new Author("ABC","Pune","30"),
                400,45);
        when(bookRepository.getBookByAuthorAddress(author.getAddress())).thenReturn(List.of(book,result1));
        assertIterableEquals(Arrays.asList(book,result1),bookService.getBookByAddress(author.getAddress()));
    }
}
