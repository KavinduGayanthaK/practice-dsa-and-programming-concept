package com.kavindu.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Integer id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Size(min = 10, message = "Description must be at least 10 characters")
    private String description;

    private boolean completed;
}