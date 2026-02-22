package com.services;

import javax.persistence.EntityManager;


import com.sales_management_system.Customer;
import com.sales_management_system.Lead;
import com.sales_management_system.SalesEmployee;

public class LeadService {

	private EntityManager em;
    public LeadService(EntityManager em) { this.em = em; }
    
	public void createLead(String name, String source, String contactInfo) { 
        em.getTransaction().begin();
        try {
            Lead l = new Lead(); 
            l.setName(name); 
            l.setSource(source); 
            l.setContactInfo(contactInfo);
            em.persist(l);
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback(); 
        }
    }

    public void assignLeadToEmployee(Long leadId, Long employeeId) { 
        em.getTransaction().begin();
        try {
            Lead l = em.find(Lead.class, leadId);
            SalesEmployee e = em.find(SalesEmployee.class, employeeId);
            if(l != null && e != null) { 
                l.setEmployee(e); 
                em.merge(l); 
            }
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback(); 
        }
    }

    public void convertLeadToCustomer(Long leadId) { 
        em.getTransaction().begin();
        try {
            Lead l = em.find(Lead.class, leadId);
            if(l != null) {
                Customer c = new Customer();
                c.setName(l.getName()); 
                c.setPhone(l.getContactInfo());
                em.persist(c);
                
                l.setCustomer(c); 
                l.setStatus("CONVERTED"); 
                em.merge(l);
            }
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback(); 
        }
    }
}
