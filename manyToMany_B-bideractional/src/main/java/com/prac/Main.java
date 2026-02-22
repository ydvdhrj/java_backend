package com.prac;

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
		
		Subject s1 = new Subject();
		s1.setId(1);
		s1.setName("java");
		s1.setNo_of_days(30);
		
		Subject s2 = new Subject();
		s2.setId(2);
		s2.setName("java backend");
		s2.setNo_of_days(40);
		
		Student st1 = new Student();
		st1.setId(1);
		st1.setName("Allen");
		st1.setGender("male");
		st1.setBranch("CSE");
		List<Subject> list1 = new ArrayList();
		list1.add(s1);
		list1.add(s2);
		st1.setSubject(list1);
		
		Student st2 = new Student();
		st2.setId(2);
		st2.setName("Riya");
		st2.setGender("female");
		st2.setBranch("ECE");
		st2.setSubject(list1);
		
		
		List<Student> student_list = new ArrayList();
		student_list.add(st1);
		student_list.add(st2);
		
		s1.setStudent(student_list);
		s2.setStudent(student_list);
		
		
		et.begin();
//		em.persist(st1);
//		em.persist(st2);
		em.find(Student.class, 1);
		et.commit();
	}
}
