package com.stackroute.EmailApp.service;

import com.stackroute.EmailApp.RabbitMQ.EmailDto;
import com.stackroute.EmailApp.model.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailServiceImpl implements emailService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;

    @Override
    public String sendEmail(EmailData emailData) {
        System.out.println(emailData);
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            System.out.println("hi1");
            // Setting up necessary details
            mailMessage.setFrom(sender);
            System.out.println("hi2");
            mailMessage.setTo(emailData.getReceiver());
            System.out.println("hi3");
            mailMessage.setText(emailData.getMailBody());
            System.out.println("hi4");
            mailMessage.setSubject(emailData.getSubject());
            System.out.println("hi5");

            // Sending the mail
            javaMailSender.send(mailMessage);
            System.out.println("hi6");
            return "Mail Sent Successfully..."+emailData.getReceiver();
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            e.printStackTrace();
            return "Error while Sending Mail";
        }
    }
}
