package com.services;

import javax.persistence.EntityManager;


import com.sales_management_system.Address;
import com.sales_management_system.Customer;

public class CustomerService {

	private EntityManager em;
    public CustomerService(EntityManager em) { this.em = em; }

	public void registerCustomer(String name, String email, String phone) { 
        em.getTransaction().begin();
        try {
            Customer c = new Customer();
            c.setName(name); 
            c.setEmail(email); 
            c.setPhone(phone);
            em.persist(c);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void addAddressToCustomer(Long customerId, Address address) { 
        em.getTransaction().begin();
        try {
            Customer c = em.find(Customer.class, customerId);
            if(c != null) { 
                c.setAddress(address); 
                address.setCustomer(c);
                em.merge(c); 
            }
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        }
    }
}
