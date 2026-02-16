package com.example.task_management_system.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_management_system.dto.TaskRequest;
import com.example.task_management_system.dto.TaskResponse;
import com.example.task_management_system.services.TaskService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}") 
    public TaskResponse getTask(@PathVariable Integer id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Integer id, @RequestBody TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deletTask(id);
    }

    @PutMapping("/{taskId}/assign/{userEmail}")
    public ResponseEntity<TaskResponse> assignTask(@PathVariable Integer taskId, @PathVariable String userEmail) {
        return ResponseEntity.ok(taskService.assignTask(taskId, userEmail));
    }
    @DeleteMapping("/{taskId}/assignee")
    public ResponseEntity<TaskResponse> removeAssignee(@PathVariable Integer taskId) {
        return ResponseEntity.ok(taskService.removeAssignee(taskId));
    }
}
