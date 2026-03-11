package com.example.task_management_system.services.email;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.task_management_system.entities.EmailLogs;
import com.example.task_management_system.repositories.EmailLogsRepository;
import com.example.task_management_system.security.SecurityUtil;

@Service
public class EmailLogService {
    private final EmailLogsRepository emailLogsRepository;

    public EmailLogService(EmailLogsRepository emailLogsRepository) {
        this.emailLogsRepository = emailLogsRepository;
    }

    public EmailLogs createLog(String toEmail, String fromEmail, String subject, String triggeredBy, String via) {
        EmailLogs log = new EmailLogs();

        log.setUserId(SecurityUtil.getCurrentUserEmail());
        log.setRecipientEmail(toEmail);
        log.setSenderEmail(fromEmail);
        log.setSubject(subject);
        log.setTriggeredBy(triggeredBy);
        log.setVia(via);
        
        return emailLogsRepository.save(log);
    }

    public void markSuccess(EmailLogs log, Integer statusCode, String messageId) {
        log.setSendTime(LocalDateTime.now());
        log.setApiResponseCode(statusCode);
        log.setSendGridMessageId(messageId);

        emailLogsRepository.save(log);
    }

    public void markFailure(EmailLogs log, Exception ex) {
        log.setFailureReason(ex.getMessage());
        emailLogsRepository.save(log);
    }
}
