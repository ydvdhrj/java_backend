package com.oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CollegeDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void insertCollege() {
		College college = new College();
		college.setId(3);
		college.setName("LPU");
		college.setLocation("jalandhar");
		college.setPincode("0012");
		
		Student s1 = new Student();
		s1.setStudent_id(106);
		s1.setName("dheeraj");
		s1.setBranch("CSE");
		
		List<Student> list = new ArrayList();
		list.add(s1);
	
		
	}
	public void deleteCollegeById(int id) {
		EntityTransaction et = em.getTransaction();
		
		Query query = em.createNativeQuery("delete from college_student where college_college_id=?1");
		query.setParameter(1, id);
		
		Query query2 = em.createNativeQuery("delete from college where college_id=?1");
		query2.setParameter(1, id);
		
		et.begin();
		query.executeUpdate();
		query2.executeUpdate();
		et.commit();
	}
}
