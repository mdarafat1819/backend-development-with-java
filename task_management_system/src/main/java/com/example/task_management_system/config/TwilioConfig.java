package com.example.task_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.task_management_system.services.email.MailSender;
import com.example.task_management_system.services.email.impl.TwilioMailSender;

@Configuration
public class TwilioConfig {
    // @Bean
    // @Primary
    // public MailSender twilioMailSender() {
    //     return new TwilioMailSender();
    // }
}
