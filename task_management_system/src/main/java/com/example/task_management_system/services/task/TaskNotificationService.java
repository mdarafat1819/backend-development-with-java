package com.example.task_management_system.services.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.task_management_system.entities.Task;
import com.example.task_management_system.entities.User;
import com.example.task_management_system.services.email.MailSender;
import com.example.task_management_system.services.email.MailSenderFactory;


@Service
public class TaskNotificationService {
    private final MailSenderFactory mailSenderFactory;
    @Value("${task_url}")
    private String taskUrl;

    public TaskNotificationService(MailSenderFactory mailSenderFactory) {
        this.mailSenderFactory = mailSenderFactory;
    }

    public void sendTaskAssignedEmail(Task task, User assignee) {
        MailSender mailSender = mailSenderFactory.getMailSender("SMTP");
       
        String message = buildTaskAssignedEmail(task, assignee, taskUrl);
        String subject = "[Task-"+task.getId()+"] : Assigned to You";

        mailSender.send(assignee.getEmail(),subject, message, "TASK_ASSIGNED_NOTIFICATION_SERVICE");
    }

     private String buildTaskAssignedEmail(Task task, User assigne, String link) {
    return """
        Dear %s,
        You have been assigned a new task.
        Task: %s,
        Task ID: %s
        View Work Item : %s
        """.formatted(assigne.getFirstName(), task.getTitle(), task.getId(), link + task.getId());
}
}
