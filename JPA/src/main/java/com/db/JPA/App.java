package com.db.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager manager = entityManagerFactory.createEntityManager();
        //Laptop laptop = new Laptop("101", "Dell");
        
        Alien alien = new Alien("1","Rajat");
        manager.getTransaction().begin();
        //manager.persist(laptop);
        // For some reason when I mark a class as @Entity JPA automatically creates a Table with no records even though I have not persisted it.
        manager.persist(alien);
        manager.getTransaction().commit();
    }
}


// In Hibernate we have the configuration class object from whch we get the Session object after which we can perform DB operations

// 