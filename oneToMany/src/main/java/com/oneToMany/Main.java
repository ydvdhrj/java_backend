package com.oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1=new Student();
		s1.setStudent_id(103);
		s1.setName("Virat");
		s1.setBranch("CSE");
		
		Student s2=new Student();
		s2.setStudent_id(104);
		s2.setName("Mohit");
		s2.setBranch("ECE");
		
		College c = new College();
		c.setId(2);
		c.setName("COE");
		c.setLocation("Delhi");
		c.setPincode("001");
		
		List<Student> list = new ArrayList();
		list.add(s1);
		list.add(s2);
		
		c.setStudent(list);
		
		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}
}
