package com.assignment_13fab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        
        // 1. Create Session Factory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // --- TASK 1: Save Aadhar Card Separately ---
        AadharCard ad = new AadharCard();
        ad.setAadharNumber(987654321);
        ad.setAddress("Mumbai, MG Road");
        ad.setIssueDate("2024-02-14");
        
        // We MUST save this manually because Cascade is OFF
        session.save(ad);

        // --- TASK 2: Save Hostel Room Separately ---
        HostelRoom room = new HostelRoom();
        room.setRoomNumber(101);
        room.setBlockName("A");
        room.setFloorName(1);
        
        // We MUST save this manually because Cascade is OFF
        session.save(room);

        // --- TASK 3: Create Student and Associate ---
        Student st = new Student();
        st.setName("Amit Kumar");
        st.setEmail("amit@gmail.com");
        st.setBranch("CSE");
        
        // Setting the foreign keys (association)
        st.setAadharCard(ad);
        st.setHostelRoom(room);
        
        session.save(st); // Save student
        
        tx.commit();
        session.close();
        
        System.out.println("Data Saved Successfully!");

        // --- TASK 4: Fetch Student ---
        Session session2 = factory.openSession();
        Student s = session2.get(Student.class, st.getStudentId()); // Fetch by ID
        
        System.out.println("Fetched Student: " + s.getName());
        System.out.println("Aadhar Address: " + s.getAadharCard().getAddress());
        System.out.println("Room Block: " + s.getHostelRoom().getBlockName());
        
        session2.close();

        // --- TASK 5: Delete Student (Verify dependencies remain) ---
        Session session3 = factory.openSession();
        Transaction tx3 = session3.beginTransaction();
        
        Student sDel = session3.get(Student.class, st.getStudentId());
        session3.delete(sDel); // Only Student is deleted
        
        tx3.commit();
        session3.close();
        
        System.out.println("Student Deleted. Check DB: Aadhar and Room should still exist.");
        
        factory.close();
    }
}