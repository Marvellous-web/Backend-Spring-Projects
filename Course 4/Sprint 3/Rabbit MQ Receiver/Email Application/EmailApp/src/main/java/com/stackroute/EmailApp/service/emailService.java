package com.stackroute.EmailApp.service;

import com.stackroute.EmailApp.model.EmailData;

public interface emailService {
    public abstract EmailData sendEmail(EmailData emailData);
}
