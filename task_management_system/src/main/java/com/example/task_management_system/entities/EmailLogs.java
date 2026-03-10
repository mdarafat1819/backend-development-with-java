package com.example.task_management_system.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "email_logs")
@Getter
@Setter
public class EmailLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;
    private String recipientEmail;
    private String senderEmail;
    private String subject;
    private String triggeredBy;
    private String via;
    private Integer apiResponseCode;
    private String sendGridMessageId;
    private LocalDateTime sendTime;
    private String failureReason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}