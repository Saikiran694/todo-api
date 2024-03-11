package com.todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${saiName}")
    public String name; 
    
    @Bean
    public Sai getSai() {
        return new Sai(name); 
    } 
}
