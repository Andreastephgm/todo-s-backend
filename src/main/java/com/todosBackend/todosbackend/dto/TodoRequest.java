package com.todosBackend.todosbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private boolean completed;
}
