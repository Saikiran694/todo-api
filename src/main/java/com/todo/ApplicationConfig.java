package com.todo;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ApplicationConfig {

    @Value("${saiName}")
    public String name; 
    
    @Bean
    public Sai getSai() {
        return new Sai(name); 
    }

    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder.name("javaguides").build();
    }

}
