package com.oneToOne_bidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Passport pass1 = new Passport();
		pass1.setId(101);
		pass1.setName("Miller");
		pass1.setDateOfBirth("21/02/2000");
		pass1.setCitizen("indian");
		
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Allen");
		p1.setEmail("Allen123@gmail.com");
		p1.setPhone(1234567890);
		
		p1.setPassport(pass1);
		pass1.setPerson(p1);
		
		et.begin();
		em.persist(p1);
//		em.persist(pass1);
		et.commit();
		
	}
}
