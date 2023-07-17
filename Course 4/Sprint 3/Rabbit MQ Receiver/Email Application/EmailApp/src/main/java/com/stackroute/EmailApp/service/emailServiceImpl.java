package com.stackroute.EmailApp.service;

import com.stackroute.EmailApp.model.EmailData;
import org.springframework.stereotype.Service;

@Service
public class emailServiceImpl implements emailService{

    @Override
    public EmailData sendEmail(EmailData emailData) {
//        System.out.println(emailData);
        return emailData;
    }
}
