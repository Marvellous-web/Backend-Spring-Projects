package com.example.H2Demo.repository;

import com.example.H2Demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepos extends CrudRepository<Book, String> {
}
