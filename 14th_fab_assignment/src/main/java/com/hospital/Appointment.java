package com.hospital;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {

	@Id
	private int id;
	private String visitDate;
	private int fee;
	@ManyToOne
	private Patient patient;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", visibleDate=" + visitDate + ", fee=" + fee + ", patient=" + patient + "]";
	}
	
}
