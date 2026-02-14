package com.oneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void insertStudent() {
		EntityTransaction et = em.getTransaction();
		Student s = new Student();
		s.setStudent_id(106);
		s.setName("santhosh");
		s.setBranch("CSE");
		
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	public void deleteStudentById(int id) {
		EntityTransaction et = em.getTransaction();
		
		Query query = em.createNativeQuery("delete from college_student where student_student_id=?1");
		query.setParameter(1, id);
		
		Student s = em.find(Student.class, id);
		
		et.begin();
		query.executeUpdate();
		em.remove(s);
		et.commit();
	}
	
//	public void updateStudent
}
