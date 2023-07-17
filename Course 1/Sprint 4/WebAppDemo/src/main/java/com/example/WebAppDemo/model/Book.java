package com.example.WebAppDemo.model;

public class Book {
    String bookname,subject,price;

    public Book() {
    }

    public Book(String bookname, String subject, String price) {
        this.bookname = bookname;
        this.subject = subject;
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", subject='" + subject + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
