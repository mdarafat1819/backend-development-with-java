package com.example.task_management_system.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.task_management_system.entities.Task;
import com.example.task_management_system.enums.Status;

public interface TaskRepository extends JpaRepository<Task, Integer> {

  @Query("""
    SELECT t FROM Task t
    WHERE t.createdBy = COALESCE(:createdBy, t.createdBy)
    AND t.status = COALESCE(:status, t.status)
    AND (:assignee IS NULL OR t.assignee.email = :assignee)
    AND t.createdDate <= COALESCE(:createdBefore, t.createdDate)
    AND t.createdDate >= COALESCE(:createdAfter, t.createdDate)
""")
List<Task> searchTasks(
        @Param("createdBy") String createdBy,
        @Param("status") Status status,
        @Param("assignee") String assignee,
        @Param("createdBefore") LocalDateTime createdBefore,
        @Param("createdAfter") LocalDateTime createdAfter
);
}