package com.prac;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	private int id;
	private String name;
	private int no_of_days;
	@ManyToMany(mappedBy = "subject")
	private List<Student> student;
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
	public int getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
}
