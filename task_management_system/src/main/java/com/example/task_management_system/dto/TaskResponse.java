package com.example.task_management_system.dto;

import com.example.task_management_system.enums.Status;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private Integer id;
    private String title;
    private String description;
    private Status status;
    private String statusDescription;
    private String assigneeEmail;
    private String assigneeName;
}
