package com.hospital;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void saveDoctor(int id, String name, String specialization, List<Appointment> appointment) {
		EntityTransaction et = em.getTransaction();
		
		Doctor d = new Doctor();
		d.setId(id);
		d.setName(name);
		d.setSpecialization(specialization);
		d.setAppointment(appointment);
		
		et.begin();
		em.persist(d);
		et.commit();
	}
	
	public Doctor findDoctor(int id) {
		Doctor d = em.find(Doctor.class, id);
		return d;
	}
	
}
