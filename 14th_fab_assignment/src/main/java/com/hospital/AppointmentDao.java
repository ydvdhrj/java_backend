package com.hospital;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppointmentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void saveAppointment(int id, String visitDate,int fee, Patient patient ) {
		EntityTransaction et = em.getTransaction();
		
		Appointment a = new Appointment();
		a.setId(id);
		a.setFee(fee);
		a.setVisitDate(visitDate);
		a.setPatient(patient);
		
		et.begin();
		em.persist(a);
		et.commit();
	}
	
	public List<Appointment> findAppointmentByDoctor(Doctor doctor) {
		List<Appointment> list = new ArrayList();
		
		Query q = em.createQuery("select d.appointment from Doctor d where d.id=?1");
		q.setParameter(1, doctor.getId());
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		list = q.getResultList();
		et.commit();
		
		return list;
	}
	
	public void updateFee(int newFee) {
		EntityTransaction et = em.getTransaction();
		Query q = em.createNativeQuery("")
	}
}
