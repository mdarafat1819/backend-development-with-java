package com.example.task_management_system.services.email.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.task_management_system.entities.EmailLogs;
import com.example.task_management_system.repositories.EmailLogsRepository;
import com.example.task_management_system.security.SecurityUtil;
import com.example.task_management_system.services.email.MailSender;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class TwilioMailSender implements MailSender {
    private final EmailLogsRepository emailLogsRepository;
    
    public TwilioMailSender(EmailLogsRepository emailLogsRepository) {
        this.emailLogsRepository = emailLogsRepository;
    }
    @Override
    public void send(String toEmail, String subject, String message, String triggered_By) {

        String fromEmail = "mdarafat1819@gmail.com";
        String senderName = "Yeasin Arafat";
        Email from = new Email(fromEmail, senderName);
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));

        Request request = new Request();

        EmailLogs emailLogs = new EmailLogs();

        emailLogs.setUserId(SecurityUtil.getCurrentUserEmail());
        emailLogs.setRecipientEmail(toEmail);
        emailLogs.setSenderEmail(fromEmail);
        emailLogs.setSubject(subject);
        emailLogs.setTriggeredBy(triggered_By);

        emailLogsRepository.save(emailLogs);
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            emailLogs.setSendTime(LocalDateTime.now());
            emailLogs.setApiResponseCode(response.getStatusCode());
            emailLogs.setSendGridMessageId(response.getHeaders().get("X-Message-Id"));

            emailLogsRepository.save(emailLogs);
           
        }catch(Exception ex) {
            emailLogs.setFailureReason(ex.getMessage());
            emailLogsRepository.save(emailLogs);
        }
    }
}
