package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entities.ToDo;
import com.todo.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService; 

    @PostMapping
    public ResponseEntity<String> saveToDoItem(@RequestBody ToDo toDoItem) {
        toDoService.saveToDOItem(toDoItem);
        return ResponseEntity.ok("Success");
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDoItems() {
        List<ToDo> items = toDoService.getAllToDoItems();
        return ResponseEntity.ok(items); 
    }
    
}
