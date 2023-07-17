package org.example.Config;

import org.example.model2.Author;
import org.example.model2.Book;
import org.springframework.context.annotation.Bean;

public class BookBeanConfig2 {
    @Bean("Book1")
    public Book getAllBooks(){
        Book b1=new Book();
        b1.setName("C Programming");
        b1.setSubject("Coding");
        b1.setPrice(999);
        return  b1;
    }
    @Bean
    public Author getAuthor(){
        return new Author("James","Wellington");
    }


}
