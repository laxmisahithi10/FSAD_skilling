package com.klu.Skill2;

import com.klu.dao.Dao;
import com.klu.entity.Product;

public class App {

    public static void main(String[] args) {

        Dao dao = new Dao();

        Product p1 = new Product("Keyboard", "Mechanical keyboard", 2500, 20);
        Product p2 = new Product("Monitor", "24 inch LED", 12000, 5);

        dao.addProduct(p1);
        dao.addProduct(p2);

        Product p = dao.getProduct(1);
        System.out.println("Product Name: " + p.getName());

        p.setPrice(2300);
        p.setQuantity(15);
        dao.updateProduct(p);

        dao.deleteProduct(2);

        System.out.println("CRUD operations completed");
    }
}