package com.JobFindingPlatform.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Value;


@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;


    @Value("${spring.mail.username}")
    private String from;
    

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        try{
            mailSender.send(message);
        }catch (Exception e){
            System.out.println("Error sending email :"+e.getMessage());
        }

    }

}