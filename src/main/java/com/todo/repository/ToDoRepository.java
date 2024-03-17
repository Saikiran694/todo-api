package com.todo.repository;

import org.springframework.data.repository.CrudRepository;
import com.todo.entities.ToDo;


public interface ToDoRepository extends CrudRepository<ToDo, Integer>{
    
}
