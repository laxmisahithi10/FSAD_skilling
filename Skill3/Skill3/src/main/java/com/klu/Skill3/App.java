package com.klu.Skill3;

import com.klu.dao.ProductDao;
import com.klu.entity.Product;

public class App {

    public static void main(String[] args) {

        ProductDao dao = new ProductDao();

        dao.insertProduct(new Product("Laptop","Electronics",60000,10));
        dao.insertProduct(new Product("Phone","Electronics",20000,15));
        dao.insertProduct(new Product("Mouse","Accessories",800,30));
        dao.insertProduct(new Product("Keyboard","Accessories",1500,20));
        dao.insertProduct(new Product("Monitor","Electronics",12000,5));
        dao.insertProduct(new Product("Speaker","Accessories",3000,12));

        dao.sortPriceAsc().forEach(p ->
            System.out.println(p.getName()+" "+p.getPrice()));
        
        dao.sortPriceDesc().forEach(p ->
        	System.out.println(p.getName()+" "+p.getPrice()));
        
        dao.sortQuantity().forEach(p ->
        	System.out.println(p.getName()+" "+p.getQuantity()));
        
        //Pagination
        dao.getPagination(0,3).forEach(p ->
            System.out.println(p.getName()));
        
        dao.getPagination(3,3).forEach(p ->
        	System.out.println(p.getName()));
        
        System.out.println("Total Products: "+dao.countProducts());
        
        
        System.out.println("Available Products: "+dao.countAvailable());
        
        Object[] price = dao.minMaxPrice();
        System.out.println("Min Price: "+price[0]);
        System.out.println("Max Price: "+price[1]);
               
        
        dao.groupByDescription();
        dao.priceRange(1000, 20000);
        dao.likeQueries();
        
    }
}