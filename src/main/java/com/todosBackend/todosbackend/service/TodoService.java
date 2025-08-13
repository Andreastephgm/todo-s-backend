package com.todosBackend.todosbackend.service;

import com.todosBackend.todosbackend.model.Todo;
import com.todosBackend.todosbackend.repository.ITodosRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private final ITodosRepository todoRepository;

    public TodoService(ITodosRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public Todo createTodo(String name){
        Todo todo = new Todo();
        todo.setName(name);
        return todoRepository.save(todo);
    }

    public List<Todo> listTodos(){
        return todoRepository.findAll();
    }

    public Todo modifyTodo(Long id, String name, boolean completed){
        Todo newTodo = todoRepository.findById(id).orElseThrow(() ->
                new EntityExistsException("Todo not found!")
                );
        newTodo.setName(name);
        newTodo.setCompleted(completed);
        return todoRepository.save(newTodo);

    }

    public void deleteTodo(Long id){
        Todo foundTodo = todoRepository.findById(id).orElseThrow(() ->
                new EntityExistsException("Todo not found!")
                );
        todoRepository.delete(foundTodo);
    }
}
