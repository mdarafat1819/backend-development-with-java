package com.example.stms_multi_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stms_multi_user.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    
}
