package com.todosBackend.todosbackend.repository;

import com.todosBackend.todosbackend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodosRepository extends JpaRepository<Todo, Long> {

}
