package com.sales_management_system;

import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("postgres");
		
	}
}
