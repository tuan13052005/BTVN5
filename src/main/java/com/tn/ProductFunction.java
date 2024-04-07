package com.tn;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class ProductFunction {

    public void showData () {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            Query<Product> query = session.createQuery("FROM Product");
            List<Product> products = query.list();
            System.out.println("Size: " + products.size());

            products.forEach(product -> {
                System.out.println("Id: " + product.getId());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Description: " + product.getDescription());
            });
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    public void insert(String productName, int price, String description) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Product> query = session.createQuery("insert into Product(productName,price,description)" + "VALUES('" + productName + "'," + price + ",'"+ description +"')");
            query.executeUpdate();
            System.out.println("Connect successfully!");
            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    public void update(int id,String productName, int price, String description) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Product> query = session.createQuery("update Product set productName = '" + productName + "', price = " + price + ", description = '"+ description +"' where id = " + id + "");
            query.executeUpdate();
            System.out.println("Connect successfully!");
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    public void delete(int id) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Product> query = session.createQuery("DELETE FROM Product where id = " +id);
            query.executeUpdate();
            System.out.println("Delete succesfully!");

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Connect fail!");
            System.out.println(ex);
        }
    }

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Product.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
