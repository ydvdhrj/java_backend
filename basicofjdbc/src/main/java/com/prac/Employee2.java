package com.prac;

import java.util.ArrayList;

public class Employee2 {
	private int id;
	private String name;
	private  int sal;
	private int age;
	private String doj;
	private String branch;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	Employee2(int id, String name, int sal, int age, String doj, String branch){
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.age = age;
		this.doj = doj;
		this.branch = branch;
	}
	
	public static ArrayList<Employee2> getEmployeeList(){
		ArrayList<Employee2> al = new ArrayList<>();
		
		al.add(new Employee2(1,"dheeraj",50000,21,"25-dec-2025","JAVA"));
		al.add(new Employee2(2,"dheeraj2",40000,21,"21-dec-2025","cpp"));
		al.add(new Employee2(3,"dheeraj3",50000,19,"25-dec-2025","JAVA"));
		al.add(new Employee2(4,"dheeraj4",50000,21,"25-dec-2025","JAVA"));
		al.add(new Employee2(5,"dheeraj5",50000,18,"25-dec-2025","JAVA"));
		
		return al;

	}
	
}
