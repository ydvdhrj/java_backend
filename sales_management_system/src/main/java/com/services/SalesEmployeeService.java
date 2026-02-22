package com.services;

import javax.persistence.EntityManager;

import com.sales_management_system.SalesEmployee;

public class SalesEmployeeService {
    private EntityManager em;
    
    public SalesEmployeeService(EntityManager em) { 
        this.em = em; 
    }

    public void addEmployee(String name, String department) { 
        em.getTransaction().begin();
        try {
            SalesEmployee emp = new SalesEmployee();
            emp.setName(name);
            emp.setDepartment(department);
            em.persist(emp);
            em.getTransaction().commit();
            System.out.println("Sales Employee added successfully! ");
        } catch(Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }
}