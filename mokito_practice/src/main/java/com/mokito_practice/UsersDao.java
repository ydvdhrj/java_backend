package com.mokito_practice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UsersDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	

	public void insertUser() {
		EntityTransaction et = em.getTransaction();
		
		Users u = new Users();
		u.setId(6);
		u.setName("shweta");
		u.setBalance(19000.0);
		
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public Users findById(int id) {
		return em.find(Users.class, id);
	}
}
