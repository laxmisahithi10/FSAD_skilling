package com.klu.Skill4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.klu.config.AppConfig;
import com.klu.entity.Student;

public class AppAnnotation {

    public static void main(String[] args) {

        ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

        Student s = context.getBean(Student.class);

        s.display();
    }
}