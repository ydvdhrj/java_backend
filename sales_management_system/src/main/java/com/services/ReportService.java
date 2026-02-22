package com.services;

import javax.persistence.EntityManager;
import com.sales_management_system.SalesEmployee;

public class ReportService {

	private EntityManager em;
    public ReportService(EntityManager em) { this.em = em; }
	
	public void getEmployeePerformance(Long employeeId) { 
        em.getTransaction().begin();
        try {
            SalesEmployee e = em.find(SalesEmployee.class, employeeId);
            if(e != null) {
                System.out.println("Performance for: " + e.getName() + " - Leads Assigned: " + e.getLeads().size());
            }
            em.getTransaction().commit();
        } catch(Exception ex) { 
            em.getTransaction().rollback(); 
        }
    }
}
