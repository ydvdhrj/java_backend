package com.services;

import javax.persistence.EntityManager;


import com.sales_management_system.Order;
import com.sales_management_system.SupportTicket;

public class TicketService {

	private EntityManager em;
    public TicketService(EntityManager em) { this.em = em; }
	
	public void raiseTicket(Long orderId, String issueDescription) { 
        em.getTransaction().begin();
        try {
            Order o = em.find(Order.class, orderId);
            SupportTicket t = new SupportTicket();
            t.setOrder(o); 
            t.setIssueDescription(issueDescription); 
            t.setStatus("OPEN");
            em.persist(t);
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback(); 
        }
    }
}
