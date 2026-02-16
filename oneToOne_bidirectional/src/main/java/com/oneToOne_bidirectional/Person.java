package com.oneToOne_bidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private int id;
	private String name;
	private int phone;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Passport passport;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", passport="
//				+ passport + "]";
//	}
	
}
