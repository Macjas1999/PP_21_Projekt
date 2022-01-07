package hibernate;


import org.hsqldb.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    public static void main(String[] args){

        System.out.println("Manager main");

        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
            Session session = entityManager.unwrap(Session.class);




        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        finally {

        }


    }
}
