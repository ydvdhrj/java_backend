package com.oneToOne_bidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	private int id;
	private String name;
	private String dateOfBirth;	
	private String citizen;
	@OneToOne(mappedBy = "passport")
	private Person person;
	public String getCitizen() {
		return citizen;
	}
	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
//	@Override
//	public String toString() {
//		return "Passport [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", citizen=" + citizen
//				+ ", person=" + person + "]";
//	}
	
	
}
