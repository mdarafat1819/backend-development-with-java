package com.example.task_management_system.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import com.example.task_management_system.security.SecurityUtil;

@Configuration
public class AuditConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return ()->Optional.of(SecurityUtil.getCurrentUserEmail());
    }
}
