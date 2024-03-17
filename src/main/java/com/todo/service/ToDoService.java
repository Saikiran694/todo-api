package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entities.ToDo;
import com.todo.repository.ToDoRepository;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository; 

    public void saveToDOItem(ToDo toDoItem) {
        toDoRepository.save(toDoItem);
    }

    public List<ToDo> getAllToDoItems() {
        return (List<ToDo>)toDoRepository.findAll();
    }
    
}
