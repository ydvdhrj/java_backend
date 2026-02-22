package com.services;

import javax.persistence.EntityManager;

import com.sales_management_system.Product;

public class ProductService {

	private EntityManager em;
    public ProductService(EntityManager em) { this.em = em; }
	
	public void addProduct(String name, double price) { 
        em.getTransaction().begin();
        try {
            Product p = new Product(); 
            p.setName(name); 
            p.setPrice(price);
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback(); 
        }
    }
}
