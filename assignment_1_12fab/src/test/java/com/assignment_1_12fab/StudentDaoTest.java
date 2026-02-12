package com.assignment_1_12fab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDaoTest {

	static EntityManagerFactory emf;
	EntityManager em;
	@BeforeAll
	public static void initEmf() {
		emf = Persistence.createEntityManagerFactory("postgres");
		
	}
	
	@BeforeEach
	public void initEm() {
		em = emf.createEntityManager();
	}
	
//	@Test
	public void testSaveStudent() {
		StudentDao dao = new StudentDao();
		Student s = new Student();
		
		s.setName("shivam");
		s.setEmail("shivam123@gmail.com");
		s.setMarks(80);
		
		String actualRes = dao.saveStudent(s);
		
		assertEquals("data inserted",actualRes);
	}
	
//	@Test
	public void testsaveNullStudent() {
		StudentDao dao = new StudentDao();
		String actualres = dao.saveStudent(null);
		assertEquals("Invalid data",actualres);
	}
	
//	@Test
	public void testFindStudentById() {
		StudentDao dao = new StudentDao();
		
		Student s = dao.findById(1);
		
		assertNotNull(s);
	}
	
//	@Test
	public void testFindByIdException() {
		StudentDao dao = new StudentDao();
		assertThrows(IllegalArgumentException.class, ()->{dao.findById(6);});
	}
	
//	@Test
	public void testFindAllStudent() {
		StudentDao dao = new StudentDao();
		assertNotNull(dao.findAllStudent());
	}
	
//	@Test
	public void testUpdateStudent() {
		StudentDao dao = new StudentDao();
		String actualres = dao.updateStudent(2, 80);
		assertEquals("Student table is updated",actualres);
		
	}
	
	@Test
	public void testDeleteStudent() {
		StudentDao dao = new StudentDao();
		
		String actualres = dao.deleteStudent(3);
		assertEquals("deleted",actualres);
	}
	
	@Test
	public void testDeleteStudentNotExisted() {
		StudentDao dao = new StudentDao();
		
		String actualres = dao.deleteStudent(8);
		assertEquals("Data does not exist",actualres);
	}
}
