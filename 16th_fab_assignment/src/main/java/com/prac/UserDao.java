package com.prac;

import javax.persistence.*;

public class UserDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    // Register User
    public void registerUser(User user) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }
}
