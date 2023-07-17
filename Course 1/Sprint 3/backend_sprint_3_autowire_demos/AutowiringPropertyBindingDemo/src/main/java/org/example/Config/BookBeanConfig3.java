package org.example.Config;

import org.example.model3.Author;
import org.example.model3.Book;
import org.springframework.context.annotation.Bean;

public class BookBeanConfig3 {
    @Bean("Book3")
    public Book getAllBooks(){
        Book b1=new Book();
        b1.setName("C Programming");
        b1.setSubject("Coding");
        b1.setPrice(999);
        b1.setAuthor(new Author("James","Wellington"));
        return  b1;
    }

    public Author getAuthor(){
        return new Author();
    }
}
