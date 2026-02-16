package manyToOne_bidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setId(101);
		s1.setName("Allen");
		s1.setBranch("CSE");
		
		
		Student s2 = new Student();
		s2.setId(102);
		s2.setName("Virat");
		
		List<Student> l1 = new ArrayList();
		l1.add(s2);
		l1.add(s1);
		
		College c1 = new College();
		c1.setId(1);
		c1.setName("ABC");
		c1.setStudent(l1);
		
		s1.setCollege(c1);
		s2.setCollege(c1);
		
		et.begin();
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}
}
