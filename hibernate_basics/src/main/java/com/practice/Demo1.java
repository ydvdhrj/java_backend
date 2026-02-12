package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("postgres");
		
		// EntityManager -> to perform crud operation
		// NOw i have  the access the to your computer dheeraj !!okiii
//		paste mat karna qki main wale test me ye log recording karenge to achanak se code aa jayega to problem he
//		 10 // a
		EntityManager em = emf.createEntityManager();
		
		//EntityTransaction -> to execute 
		EntityTransaction et = em.getTransaction();
		
		Student student = em.find(Student.class, 1);
		
		System.out.println(student.getId()+" "+student.getName()+" "+student.getDob()+" "+student.getPercentage());
		
		emf.close();
	}
}
