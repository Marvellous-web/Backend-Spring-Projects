package com.stackroute.MongoRepository.BookCrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason="Book already exists")
public class BookAlreadyExistException extends Exception {
}
