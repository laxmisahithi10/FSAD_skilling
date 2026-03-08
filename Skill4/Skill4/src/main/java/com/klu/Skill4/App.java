package com.klu.Skill4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.entity.Student;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
        new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Student s = (Student) context.getBean("student");

        s.display();
    }
}