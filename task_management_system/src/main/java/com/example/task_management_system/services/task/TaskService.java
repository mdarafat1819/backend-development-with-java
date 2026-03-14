package com.example.task_management_system.services.task;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.stereotype.Service;

import com.example.task_management_system.dto.TaskRequest;
import com.example.task_management_system.dto.TaskResponse;
import com.example.task_management_system.entities.Task;
import com.example.task_management_system.entities.User;
import com.example.task_management_system.enums.Status;
import com.example.task_management_system.exceptions.TaskNotFoundException;
import com.example.task_management_system.exceptions.UserNotFoundException;
import com.example.task_management_system.repositories.TaskRepository;
import com.example.task_management_system.repositories.UserRepository;
import com.example.task_management_system.security.SecurityUtil;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskNotificationService taskNotification;
    private final ModelMapper modelMapper;
    Logger logger = LoggerFactory.getLogger(TaskService.class);

    public TaskService(TaskRepository taskRepository, UserRepository userRepository,
            TaskNotificationService taskNotification, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.taskNotification = taskNotification;
    }

    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        Type listType = new TypeToken<List<TaskResponse>>() {
        }.getType();

        logger.info("Log: getAllTask");
        return modelMapper.map(tasks, listType);
    }

    public List<TaskResponse>searchTasks(String createdBy, Status status, String assignee, LocalDateTime createdBefore, LocalDateTime createdAfter) {
        List<Task> tasks = taskRepository.searchTasks(
        createdBy,
        status,
        assignee,
        createdBefore,
        createdAfter
);
        Type listType = new TypeToken<List<TaskResponse>>(){}.getType();

        return modelMapper.map(tasks, listType);
    }

    public TaskResponse getTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return modelMapper.map(task, TaskResponse.class);
    }

    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = modelMapper.map(taskRequest, Task.class);
        return modelMapper.map(taskRepository.save(task), TaskResponse.class);
    }

    public void deleteTask(Integer id) {

        Task task = taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException(id));

        if (!isAuthorized(task)) {
            throw new AuthorizationDeniedException("You are not authorized to delete this task.");
        }

        taskRepository.deleteById(id);
    }

    public TaskResponse updateTask(Integer id, TaskRequest updateTaskRequest) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        if (!isAuthorized(existingTask)) {
            throw new AuthorizationDeniedException("You are not authorized to update this task.");
        }

        if (updateTaskRequest.getTitle() != null)
            existingTask.setTitle(updateTaskRequest.getTitle());
        if (updateTaskRequest.getDescription() != null)
            existingTask.setDescription(updateTaskRequest.getDescription());
        if (updateTaskRequest.getStatus() != null)
            existingTask.setStatus(updateTaskRequest.getStatus());

        return modelMapper.map(taskRepository.save(existingTask), TaskResponse.class);
    }

    public TaskResponse assignTask(Integer taskId, String assigneeEmail) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        User assignee = userRepository.findByEmail(assigneeEmail)
                .orElseThrow(() -> new UserNotFoundException(assigneeEmail));

        task.setAssignee(assignee);
        taskRepository.save(task);
        taskNotification.notifyTaskAssigned(task, assignee);

        return modelMapper.map(task, TaskResponse.class);
    }

    public TaskResponse removeAssignee(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFoundException(taskId));
        User oldAssignee = task.getAssignee();
        task.setAssignee(null);
        taskRepository.save(task);

        if (oldAssignee != null)
            taskNotification.notifyAssigneeRemoved(task, oldAssignee);

        return modelMapper.map(task, TaskResponse.class);
    }

    private boolean isAuthorized(Task task) {
        String currentUserEmail = SecurityUtil.getCurrentUserEmail();
        String currentUserRole = SecurityUtil.getUserRole();

        return task.getCreatedBy().equals(currentUserEmail) || currentUserRole.equals("ADMIN");
    }
}
