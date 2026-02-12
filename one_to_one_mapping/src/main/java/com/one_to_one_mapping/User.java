package com.one_to_one_mapping;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class User {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		
	}
}
