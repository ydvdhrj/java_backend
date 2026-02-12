package com.assignment_1_12fab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	EntityManager em = emf.createEntityManager();

	public String saveStudent(Student s) {
		EntityTransaction et = em.getTransaction();
		
		if(s!=null) {
			et.begin();
			em.persist(s);
			et.commit();
			return "data inserted";
		}
		else {
			return "Invalid data";
		}
	}
	
	public Student findById(int id) {
		
		Student s = em.find(Student.class, id);
		if(s!=null) {
			return s;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	
	public List<Student> findAllStudent(){
		
		String jpql = "select s from Student s";
		
		Query query  = em.createQuery(jpql);
		
		List<Student> list = query.getResultList();
		
		return list;
	}
	
	public String updateStudent(int id,int marks) {
		EntityTransaction et = em.getTransaction();
		
		String jpql = "Update Student s set s.marks=?1 where s.id=?2";
		
		et.begin();
		Query query = em.createQuery(jpql);
		query.setParameter(1, marks);
		query.setParameter(2, id);
		query.executeUpdate();
		et.commit();
		
		return "Student table is updated";
	}
	
	public String deleteStudent(int id) {
		Student s = em.find(Student.class, id);
		
		if(s!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(s);
			et.commit();
			return "deleted";
		}
		else {
			return "Data does not exist";
		}
	}
}
