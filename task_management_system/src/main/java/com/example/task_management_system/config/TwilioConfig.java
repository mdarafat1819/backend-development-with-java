package com.example.task_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
public class TwilioConfig {
    @Bean
    SendGrid sendGrid() {
         return new SendGrid(System.getenv("SENDGRID_API_KEY"));
    }
}
