package com.todo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.todo.payload.User;

@Service
@ConditionalOnProperty(name = "kafka.enabled", havingValue = "true")
public class JsonKafkaProducer {

    private static final  Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    KafkaTemplate<String, User> kafkaTemplate; 

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate; 
    }

    public void sendMessage(User user) {

        LOGGER.info(String.format("Message being sent is --> %s ", user.toString()));
        Message<User> message = MessageBuilder.
             withPayload(user).
            setHeader(KafkaHeaders.TOPIC, "javaguides")
            .build();
        kafkaTemplate.send(message);
    } 
    
}
