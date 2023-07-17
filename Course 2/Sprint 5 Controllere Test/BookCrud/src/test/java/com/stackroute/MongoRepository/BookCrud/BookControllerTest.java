package com.stackroute.MongoRepository.BookCrud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MongoRepository.BookCrud.controller.BookController;
import com.stackroute.MongoRepository.BookCrud.exception.BookAlreadyExistException;
import com.stackroute.MongoRepository.BookCrud.exception.BookNotFoundException;
import com.stackroute.MongoRepository.BookCrud.model.Author;
import com.stackroute.MongoRepository.BookCrud.model.Book;
import com.stackroute.MongoRepository.BookCrud.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
//import static org.springframework.http.RequestEntity.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private BookService bookService;
    @InjectMocks
    private BookController bookController;

    private Book book,book1;
    private Author author;

    @BeforeEach
    public void setup(){
        author=new Author("Robin","Pune","25");
        book=new Book("BK001","C++","Programing",author,500,20);
        book1=new Book("BK002","Java","ProgramingCoding",author,999,59);
        mockMvc= MockMvcBuilders.standaloneSetup(bookController).build();
    }
    @AfterEach
    public void clean(){
        book=null;book1=null;author=null;
    }
    @Test
    public void TestControllerAddBookSuccess() throws Exception{
        when(bookService.addBooks(book)).thenReturn(book);
        mockMvc.perform(
                post("/addBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(convertToJson(book))).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).addBooks(book);

    }
    public static String convertToJson(final Object object){
        String result="";
        ObjectMapper mapper=new ObjectMapper();
        try{
            result= mapper.writeValueAsString(object);
        }catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Test
    public void TestControllerAddBookFailure() throws Exception {
        when(bookService.addBooks(book)).thenThrow(BookAlreadyExistException.class);
        mockMvc.perform(
                post("/addBook").contentType(MediaType.APPLICATION_JSON)
                        .content(convertToJson(book)))
                        .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).addBooks(book);
    }
    @Test
    public void TestControllerDeleteBookSuccess() throws Exception {
        when(bookService.deleteBook("BK001")).thenReturn(true);
        mockMvc.perform(
                delete("/delete-book-by-id/BK001")).
                andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).deleteBook("BK001");

    }
    @Test
    public void TestControllableDeleteBookFailure() throws Exception{
        when(bookService.deleteBook("BK001")).thenThrow(BookNotFoundException.class);
        mockMvc.perform(
                delete("/delete-book-by-id/BK001").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).deleteBook("BK001");

    }
    @Test
    public void TestControllableGetBook() throws Exception {
        when(bookService.getAllBook()).thenReturn(List.of(book,book1));
        mockMvc.perform(
                        get("/getAllBook"))
                .andExpect(status().isOk()).
                andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).getAllBook();
    }
    @Test
    public void TestControllableUpdateBook() throws Exception{
        when(bookService.updateBook(book)).thenReturn(book);
        mockMvc.perform(
                put("/updateBook").contentType(MediaType.APPLICATION_JSON).
                        content(convertToJson(book))).
                        andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).updateBook(book);
}
    @Test
    public void TestControllableUpdateBookFailure() throws Exception{
        when(bookService.updateBook(book)).thenThrow(BookNotFoundException.class);
        mockMvc.perform(
                put("/updateBook").contentType(MediaType.APPLICATION_JSON).
                        content(convertToJson(book))).andExpect(status().isNotFound()).
                andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).updateBook(book);

    }

    @Test
    public void TestControllableGetById() throws Exception{
        when(bookService.getBookById("BK001")).thenReturn(book);
        mockMvc.perform(
                get("/get-book-by-id/BK001")).andExpect(status().isOk()).
                andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).getBookById("BK001");

    }
    @Test
    public void TestControllableGetByIdFailure() throws Exception{
        when(bookService.getBookById("BK002")).thenThrow(BookNotFoundException.class);
        mockMvc.perform(
                        get("/get-book-by-id/BK002")).andExpect(status().isNotFound()).
                andDo(MockMvcResultHandlers.print());
        verify(bookService,times(1)).getBookById("BK002");

    }






}
