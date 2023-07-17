package com.example.SpringMC1.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage(){
        String abc="Good day to you!";
        return abc;
    }


}
