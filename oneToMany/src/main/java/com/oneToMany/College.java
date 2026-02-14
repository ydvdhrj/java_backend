package com.oneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {

	@Id
	private int college_id;
	private String name;
	private String location;
	private String pincode;
	@OneToMany
	private List<Student> student;
	public int getId() {
		return college_id;
	}
	public void setId(int id) {
		this.college_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "College [id=" + college_id + ", name=" + name + ", location=" + location + ", pincode=" + pincode + ", student="
				+ student + "]";
	}
	
}
