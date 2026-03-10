package com.example.task_management_system.services.email.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.task_management_system.entities.EmailLogs;
import com.example.task_management_system.services.email.EmailLogService;
import com.example.task_management_system.services.email.MailSender;

@Service("smtpMailSender")
public class SmtpMailSender implements MailSender {
    private final JavaMailSender mailSender;
    private final EmailLogService logService;

    public SmtpMailSender(JavaMailSender mailSender, EmailLogService logService) {
        this.mailSender = mailSender;
        this.logService = logService;
    }

    @Override
    public void send(String toEmail, String subject, String message, String triggered_By) {
        SimpleMailMessage mailContents = new SimpleMailMessage();

        String fromEmail = "mdarafat1819@gmail.com";

        mailContents.setTo(toEmail);
        mailContents.setSubject(subject);
        mailContents.setText(message);

        EmailLogs log = logService.createLog(toEmail, fromEmail, subject, triggered_By, "SMTP");

        try {
            mailSender.send(mailContents);

            logService.markSuccess(log, 200, "N/A");
        } catch (Exception ex) {
           logService.markFailure(log, ex);
        }

    }
}
