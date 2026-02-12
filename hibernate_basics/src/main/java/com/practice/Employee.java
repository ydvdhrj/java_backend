package com.practice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int id;
	private String name;
	private double salary;
	
	
	
}
