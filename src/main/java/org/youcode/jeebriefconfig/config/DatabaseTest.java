package org.youcode.jeebriefconfig.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            // Create an EntityManagerFactory
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
            // Create an EntityManager
            entityManager = entityManagerFactory.createEntityManager();

            // Test connection by beginning a transaction
            entityManager.getTransaction().begin();
            System.out.println("Connection to the database is successful!");

            // Commit the transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        } finally {
            // Close the EntityManager and EntityManagerFactory
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}