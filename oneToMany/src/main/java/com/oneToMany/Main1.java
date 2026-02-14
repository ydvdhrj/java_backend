package com.oneToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		College c=em.find(College.class, 1);
//		
//		List<Student> list = c.getStudent();
//		Student s=new Student();
//		s.setStudent_id(105);
//		s.setBranch("IT");
//		s.setName("Adam");
//		
//		list.add(s);
//		
//		c.setStudent(list);
//		
//		et.begin();
//		em.persist(s);
//		et.commit();
		
//		StudentDao sdao = new StudentDao();
//		sdao.deleteStudentById(105);
		
		CollegeDao cdao = new CollegeDao();
		cdao.deleteCollegeById(1);
	}
}
