package org.example.model1;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
    private String name,subject;
    private int price;

    @Autowired
    private Author author;

    public Book() {
    }

    public Book(String name, String subject, int price, Author author) {
        this.name = name;
        this.subject = subject;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
