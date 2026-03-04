package com.example.task_management_system.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TempUser {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @UpdateTimestamp
    private LocalDateTime submittedAt;
}
