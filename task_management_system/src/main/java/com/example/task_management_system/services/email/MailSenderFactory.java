package com.example.task_management_system.services.email;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MailSenderFactory {
    private final Map<String, MailSender> mailSender;

    public MailSenderFactory(Map<String, MailSender> mailSender) {
        this.mailSender = mailSender;
    }

    public MailSender getMailSender(String provider) {
        if(provider.equalsIgnoreCase("TWILIO-SENDGRID")) {
            return mailSender.get("twilioMailSender");
        }
        if(provider.equalsIgnoreCase("SMTP")) {
            return mailSender.get("smtpMailSender");
        }

        throw new IllegalArgumentException("Unknown mail provider");
    }
}
