package com.todosBackend.todosbackend.controller;

import com.todosBackend.todosbackend.dto.TodoRequest;
import com.todosBackend.todosbackend.model.Todo;
import com.todosBackend.todosbackend.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo(@RequestBody @Valid TodoRequest todoRequest){
        return todoService.createTodo(todoRequest.getName());
    }

    @GetMapping
    public List<Todo> listTodo(){
        return todoService.listTodos();
    }

    @PutMapping("/{id}")
    public Todo modifyTodo(@PathVariable Long id, @RequestBody @Valid TodoRequest todoRequest){
       return todoService.modifyTodo(id, todoRequest.getName(), todoRequest.isCompleted());
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}
