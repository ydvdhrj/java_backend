package com.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void insertEmployee() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Rohit");
		e.setSalary(50000.0);
		e.setDesignation("HOD");
		
		Department d = new Department();
		d.setD_id(1);
		d.setName("TPO");
		d.setManager_name("santhosh");
		d.setNo_of_emp(20);
		
		e.setDepartment(d);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(e);
		et.commit();
	}
	
}
