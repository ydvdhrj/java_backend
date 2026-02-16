package com.manyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "number_sequence")
	@SequenceGenerator(name = "number_sequnce",sequenceName = "number_sequence",initialValue = 100,allocationSize = 1)
	private int d_id;
	private String name;
	private String manager_name;
	private int no_of_emp;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public int getNo_of_emp() {
		return no_of_emp;
	}
	public void setNo_of_emp(int no_of_emp) {
		this.no_of_emp = no_of_emp;
	}
	@Override
	public String toString() {
		return "Department [d_id=" + d_id + ", name=" + name + ", manager_name=" + manager_name + ", no_of_emp="
				+ no_of_emp + "]";
	}
	
}
