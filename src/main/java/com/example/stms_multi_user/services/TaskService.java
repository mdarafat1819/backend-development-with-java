package com.example.stms_multi_user.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.example.stms_multi_user.entities.Task;
import com.example.stms_multi_user.repositories.TaskRepository;
import com.example.stms_multi_user.security.SecurityUtil;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task>getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Task getTask(Integer id) {
        return taskRepository.findById(id).orElseThrow(()->
            new RuntimeException("Task not found with id " + id)
        );
    }

    public Task createTask(Task task) {
        task.setCreatedDate(LocalDateTime.now());
        task.setCreatedBy(SecurityUtil.getCurrentUserEmail());
        task.setUpdateDate(LocalDateTime.now());
        task.setUpdatedBy(SecurityUtil.getCurrentUserEmail());
        return taskRepository.save(task);
    }

    public void deletTask(Integer id) {
        if(!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id " + id);
        }

        taskRepository.deleteById(id);
    }

    public Task updateTask(Integer id, Task updateTask) {
        Task existingTask = taskRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Task not found with id " + id));

        existingTask.setTitle(updateTask.getTitle());
        existingTask.setDescription(updateTask.getDescription());
        existingTask.setStatus(updateTask.getStatus());

        existingTask.setUpdateDate(LocalDateTime.now());
        existingTask.setUpdatedBy(SecurityUtil.getCurrentUserEmail());

       return taskRepository.save(existingTask);
    }
}
