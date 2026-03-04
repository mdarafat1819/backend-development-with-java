package com.example.task_management_system.services.email.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.task_management_system.services.email.MailSender;

@Service
public class SmtpMailSender implements MailSender {
    private final JavaMailSender mailSender;

    public SmtpMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String toEmail, String subject, String message) {
        SimpleMailMessage mailContents = new SimpleMailMessage();

        mailContents.setTo(toEmail);
        mailContents.setSubject(subject);
        mailContents.setText(message);

        mailSender.send(mailContents);
    }
}
