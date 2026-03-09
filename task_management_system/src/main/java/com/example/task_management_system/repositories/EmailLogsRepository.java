package com.example.task_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task_management_system.entities.EmailLogs;

@Repository
public interface EmailLogsRepository extends JpaRepository<EmailLogs, Long> {

} 
