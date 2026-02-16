package com.hospital;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
	private int id;
	private String name;
	private String specialization;
	@OneToMany
	private List<Appointment> appointment;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", appointment="
				+ appointment + "]";
	}
	
}
