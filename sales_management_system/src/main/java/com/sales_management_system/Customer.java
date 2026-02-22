package com.sales_management_system;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String email;
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToOne(mappedBy = "customer")
	private Lead lead;

	public String getDetails() {
		return "Customer: " + name + ", Email: " + email + ", Phone: " + phone;
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
