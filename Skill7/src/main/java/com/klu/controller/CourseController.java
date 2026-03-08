package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

   @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        if (course.getTitle() == null) {
            return new ResponseEntity<>("Invalid course data", HttpStatus.BAD_REQUEST);
        }

        service.addCourse(course);

        return new ResponseEntity<>("Course Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {

        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody Course course) {

        return service.updateCourse(id, course)
                .<ResponseEntity<?>>map(updated ->
                        new ResponseEntity<>(updated, HttpStatus.OK))
                .orElseGet(() ->
                        new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        boolean removed = service.deleteCourse(id);

        if (removed) {
            return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title) {

        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }

}