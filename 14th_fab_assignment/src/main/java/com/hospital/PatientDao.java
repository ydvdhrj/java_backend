package com.hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PatientDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void savePatient(int id, String name, int age, int contact, MedicalRecord medicalRecord) {
		EntityTransaction et = em.getTransaction();
		
		Patient p = new Patient();
		p.setId(id);
		p.setName(name);
		p.setAge(age);
		p.setContact(contact);
		p.setMedicalRecord(medicalRecord);
		
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public Patient findPatientById(int id) {
		
		Patient p = em.find(Patient.class, id);
		return p;
	}
	
	public void updatePatient(int id) {
		EntityTransaction et = em.getTransaction();
		
		Query query = em.createNamedQuery("update patient set age=20 where id=?1");
		query.setParameter(1, id);
		
		et.begin();
		query.executeUpdate();
		et.commit();
	}
	
	public void deletePatient(int id) {
		EntityTransaction et = em.getTransaction();
		
		Query q = em.createNativeQuery("delete from patient where id=?1");
		q.setParameter(1, id);
		
		et.begin();
		q.executeUpdate();
		et.commit();
	}
}
