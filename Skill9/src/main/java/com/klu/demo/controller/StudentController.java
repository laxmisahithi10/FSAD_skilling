package com.klu.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.klu.demo.exception.InvalidInputException;
import com.klu.demo.exception.StudentNotFoundException;
import com.klu.demo.model.Student;

@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {

        if(id <= 0){
            throw new InvalidInputException("Student ID must be positive");
        }

        if(id != 101){
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return new Student(101,"Sahithi","CSE");
    }

}