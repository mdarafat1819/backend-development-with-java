package com.example.task_management_system.services.email.impl;

import com.example.task_management_system.services.email.MailSender;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class TwilioMailSender implements MailSender {
    @Override
    public void send(String toEmail, String subject, String message, String apiPath) {

        Email from = new Email("mdarafat1819@gmail.com", "Yeasin Arafat");
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            System.out.println("Hello From Twilio Mail Sender");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
           // System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            String messageId = response.getHeaders().get("X-Message-Id");
            System.out.println("SendGrid Message ID: " + messageId);
            System.out.println("Triggered_By: " + apiPath);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
