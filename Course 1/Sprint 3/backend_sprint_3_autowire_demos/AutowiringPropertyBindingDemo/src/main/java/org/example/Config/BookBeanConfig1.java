package org.example.Config;

import org.example.model1.Author;
import org.example.model1.Book;
import org.springframework.context.annotation.Bean;

public class BookBeanConfig1 {
    @Bean("Book")
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
