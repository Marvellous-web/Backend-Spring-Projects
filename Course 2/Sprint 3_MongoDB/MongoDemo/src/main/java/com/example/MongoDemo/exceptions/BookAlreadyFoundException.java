package com.example.MongoDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Book Already Exist")
public class BookAlreadyFoundException extends Exception{

}
