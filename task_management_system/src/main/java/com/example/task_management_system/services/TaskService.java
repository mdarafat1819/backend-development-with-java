package com.example.task_management_system.services;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.stereotype.Service;

import com.example.task_management_system.dto.TaskRequest;
import com.example.task_management_system.dto.TaskResponse;
import com.example.task_management_system.entities.Task;
import com.example.task_management_system.entities.User;
import com.example.task_management_system.exceptions.TaskNotFoundException;
import com.example.task_management_system.exceptions.UserNotFoundException;
import com.example.task_management_system.repositories.TaskRepository;
import com.example.task_management_system.repositories.UserRepository;
import com.example.task_management_system.security.SecurityUtil;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<TaskResponse> getAllTasks() {
        List<Task>tasks = taskRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
       Type listType = new TypeToken<List<TaskResponse>>() {}.getType();
        
        return modelMapper.map(tasks, listType);
    }

    public TaskResponse getTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return modelMapper.map(task, TaskResponse.class);
    }
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = modelMapper.map(taskRequest, Task.class);
        task.setCreatedDate(LocalDateTime.now());
        task.setCreatedBy(SecurityUtil.getCurrentUserEmail());
        return modelMapper.map(taskRepository.save(task), TaskResponse.class);
    }

    public void deletTask(Integer id) {

        Task task = taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException(id));

        String currentUserEmail = SecurityUtil.getCurrentUserEmail();
        String currentUserRole = SecurityUtil.getUserRole();

        if (task.getCreatedBy().equals(currentUserEmail) || currentUserRole.equals("ADMIN")) {
            taskRepository.deleteById(id);
        } else
            throw new AuthorizationDeniedException("You are not authorized to delete this task.");
    }

    public TaskResponse updateTask(Integer id, TaskRequest updateTaskRequest) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        String currentUserEmail = SecurityUtil.getCurrentUserEmail();
        String currentUserRole = SecurityUtil.getUserRole();

        Task updateTask = modelMapper.map(updateTaskRequest, Task.class);

        if (updateTask.getTitle() != null)
            existingTask.setTitle(updateTask.getTitle());
        if (updateTask.getDescription() != null)
            existingTask.setDescription(updateTask.getDescription());
        if (updateTask.getStatus() != null)
            existingTask.setStatus(updateTask.getStatus());

        existingTask.setUpdateDate(LocalDateTime.now());
        existingTask.setUpdatedBy(SecurityUtil.getCurrentUserEmail());

        if (existingTask.getCreatedBy().equals(currentUserEmail) || currentUserRole.equals("ADMIN")) {
            return modelMapper.map(taskRepository.save(existingTask), TaskResponse.class);
        } else
            throw new AuthorizationDeniedException("You are not authorized to update this task.");

    }

    public TaskResponse assignTask(Integer taskId, String assigneeEmail) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        User user = userRepository.findByEmail(assigneeEmail).orElseThrow(()-> new UserNotFoundException(assigneeEmail));

        task.setAssignee(user);
        task.setUpdateDate(LocalDateTime.now());
        task.setUpdatedBy(SecurityUtil.getCurrentUserEmail());

        taskRepository.save(task);

       return modelMapper.map(task, TaskResponse.class);
    }

    public TaskResponse removeAssignee(Integer taskId) {
        System.out.println("Hello from removeAssignee API");
        Task task = taskRepository.findById(taskId).orElseThrow(
            ()->new TaskNotFoundException(taskId)
        );

        task.setAssignee(null);
        task.setUpdateDate(LocalDateTime.now());
        task.setUpdatedBy(SecurityUtil.getCurrentUserEmail());
        taskRepository.save(task);

        return modelMapper.map(task, TaskResponse.class);
    }
}
