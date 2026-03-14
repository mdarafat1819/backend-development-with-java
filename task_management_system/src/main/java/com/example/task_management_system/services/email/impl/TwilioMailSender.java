package com.example.task_management_system.services.email.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.task_management_system.entities.EmailLogs;
import com.example.task_management_system.services.email.EmailLogService;
import com.example.task_management_system.services.email.MailSender;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service("twilioMailSender")
public class TwilioMailSender implements MailSender {
    private final SendGrid sendGrid;
    private final EmailLogService logService;
    private final Logger logger = LoggerFactory.getLogger(TwilioMailSender.class);
   
    public TwilioMailSender(SendGrid sendGrid, EmailLogService logService) {
        this.sendGrid = sendGrid;
        this.logService = logService;
    }
    @Override
    public void send(String toEmail, String subject, String message, String triggered_By) {

        String fromEmail = "mdarafat1819@gmail.com";
        String senderName = "Task Management System";
        Email from = new Email(fromEmail, senderName);
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        EmailLogs log = logService.createLog(toEmail, fromEmail, subject, triggered_By, "TWILIO-SENDGRID");

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);

           logService.markSuccess(log, response.getStatusCode(), response.getHeaders().get("X-Message-Id"));
           logger.info("Send Grid API Status Code: " + response.getStatusCode());
           
        }catch(Exception ex) {
            logService.markFailure(log, ex);

            logger.error(ex.getMessage());
        }
    }
}
