package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.kafka.JsonKafkaProducer;
import com.todo.kafka.KafkaProducer;
import com.todo.payload.User;


@RestController
public class KafkaMessageController {

    @Autowired(required = false)
    KafkaProducer kafkaProducer; 

    @Autowired(required = false)
    JsonKafkaProducer jsonKafkaProducer; 

    @GetMapping("/message/{message}")
    private ResponseEntity<String> sendMessageToKafkaTopic(@PathVariable("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok(message); 
    }

    @PostMapping("/message")
    public ResponseEntity<String> sendJsonMessageToKafka(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Success");

    }
}