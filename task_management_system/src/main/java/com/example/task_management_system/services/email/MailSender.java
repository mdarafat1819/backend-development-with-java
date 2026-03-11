package com.example.task_management_system.services.email;

public interface MailSender {

        public void send(String toEmail, String subject, String message, String triggeredBy);
} 
