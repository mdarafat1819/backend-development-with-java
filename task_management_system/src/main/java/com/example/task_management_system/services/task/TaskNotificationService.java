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

    public void notifyTaskAssigned(Task task, User assignee) {
        MailSender mailSender = mailSenderFactory.getMailSender("TWILIO-SENDGRID");
       
        String message = buildTaskAssignedNotification(task, assignee, taskUrl);
        String subject = "[Task-"+task.getId()+"] : Assigned to You";

        mailSender.send(assignee.getEmail(),subject, message, "TASK_ASSIGNED_NOTIFICATION_SERVICE");
    }

     private String buildTaskAssignedNotification(Task task, User assignee, String link) {
    return """
        Dear %s,
        You have been assigned a new task.
        Task: %s,
        Task ID: %s
        View Work Item : %s
        """.formatted(assignee.getFirstName(), task.getTitle(), task.getId(), link + task.getId());
}

    public void notifyAssigneeRemoved(Task task, User assignee) {
        MailSender mailSender = mailSenderFactory.getMailSender("SMTP");
        String subject = "Task Assignment Removed";
        String messageBody = buildAssigneeRemovedNotification(task, assignee, taskUrl);
        mailSender.send(assignee.getEmail(), subject, messageBody, "TASK_REMOVED_NOTIFICAITON_SERVICE");
    }
    private String buildAssigneeRemovedNotification(Task task, User assignee, String link) {
        return """
        Dear %s,
        You have been removed as the assignee for the following task:
        Task: %s,
        Task ID: %s
        View Work Item : %s
        Regards,
        Task Management System
        """.formatted(assignee.getFirstName(), task.getTitle(), task.getId(), link + task.getId());
    }
}
