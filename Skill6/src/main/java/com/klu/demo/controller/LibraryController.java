package com.klu.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.demo.model.Book;

@RestController
public class LibraryController {

    List<Book> books = new ArrayList<>();

    // Task 2
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library";
    }

    // Task 3
    @GetMapping("/count")
    public int countBooks() {
        return 120;
    }

    // Task 4
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // Task 5
    @GetMapping("/books")
    public List<String> bookTitles() {
        return Arrays.asList("Java", "Spring Boot", "Hibernate", "Python");
    }

    // Task 6
    @GetMapping("/books/{id}")
    public String bookById(@PathVariable int id) {
        return "Details of book with id: " + id;
    }

    // Task 7
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // Task 8
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // Task 9
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully";
    }

    // Task 10
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return books;
    }
}