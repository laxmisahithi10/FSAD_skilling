package com.klu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class ProductDao {

    public void insertProduct(Product p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }

    // SORT BY PRICE ASC
    public List<Product> sortPriceAsc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery(
                "FROM Product ORDER BY price ASC", Product.class);
        return q.list();
    }

    // SORT BY PRICE DESC
    public List<Product> sortPriceDesc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery(
                "FROM Product ORDER BY price DESC", Product.class);
        return q.list();
    }

    // SORT BY QUANTITY
    public List<Product> sortQuantity() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery(
                "FROM Product ORDER BY quantity DESC", Product.class);
        return q.list();
    }

    // PAGINATION
    public List<Product> getPagination(int start, int count) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery("FROM Product", Product.class);
        q.setFirstResult(start);
        q.setMaxResults(count);
        return q.list();
    }

    // COUNT ALL
    public Long countProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Long> q = session.createQuery(
                "SELECT COUNT(*) FROM Product", Long.class);
        return q.uniqueResult();
    }

    // COUNT quantity > 0
    public Long countAvailable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Long> q = session.createQuery(
                "SELECT COUNT(*) FROM Product WHERE quantity>0", Long.class);
        return q.uniqueResult();
    }

    // MIN MAX PRICE
    public Object[] minMaxPrice() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Object[]> q = session.createQuery(
                "SELECT MIN(price), MAX(price) FROM Product", Object[].class);
        return q.uniqueResult();
    }
    
    //Group by
    public void groupByDescription() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Object[]> q = session.createQuery(
            "SELECT description, COUNT(*) FROM Product GROUP BY description",
            Object[].class
        );
        List<Object[]> list = q.list();
        for(Object[] row : list) {
            System.out.println("Description: " + row[0] + " Count: " + row[1]);
        }
        session.close();
    }
    
    //Range
    public void priceRange(double min, double max) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery(
            "FROM Product WHERE price BETWEEN :min AND :max",
            Product.class
        );
        q.setParameter("min", min);
        q.setParameter("max", max);
        List<Product> list = q.list();
        for(Product p : list) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
        session.close();
    }
    
    //Queries
    public void likeQueries() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // names starting with L
        Query<Product> q1 = session.createQuery(
            "FROM Product WHERE name LIKE 'L%'", Product.class);
        System.out.println("Starting with L:");
        q1.list().forEach(p -> System.out.println(p.getName()));

        // names ending with r
        Query<Product> q2 = session.createQuery(
            "FROM Product WHERE name LIKE '%r'", Product.class);
        System.out.println("Ending with r:");
        q2.list().forEach(p -> System.out.println(p.getName()));

        // names containing substring
        Query<Product> q3 = session.createQuery(
            "FROM Product WHERE name LIKE '%top%'", Product.class);
        System.out.println("Containing 'top':");
        q3.list().forEach(p -> System.out.println(p.getName()));

        // exact length
        Query<Product> q4 = session.createQuery(
            "FROM Product WHERE LENGTH(name)=5", Product.class);
        System.out.println("Name length = 5:");
        q4.list().forEach(p -> System.out.println(p.getName()));

        session.close();
    }

}