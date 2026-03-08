package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.entity.Student;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {

        Student s = new Student(102,"Rahul","AI",3);

        s.setCourse("Artificial Intelligence");
        s.setYear(3);

        return s;
    }
}