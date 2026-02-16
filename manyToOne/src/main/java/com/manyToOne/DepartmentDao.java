package com.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DepartmentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
}
