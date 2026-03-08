package com.klu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.demo.model.Product;
import com.klu.demo.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product p) {

        repo.save(p);
        return "Product Added";
    }

   @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {

        return repo.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min,
                                     @RequestParam double max) {

        return repo.findByPriceBetween(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> sortProducts() {

        return repo.sortByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {

        return repo.findExpensiveProducts(price);
    }

}