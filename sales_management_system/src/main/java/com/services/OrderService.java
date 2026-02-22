package com.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.sales_management_system.Customer;
import com.sales_management_system.Order;
import com.sales_management_system.Product;

public class OrderService {

	private EntityManager em;
    public OrderService(EntityManager em) { this.em = em; }
	
	public void placeOrder(Long customerId, List<Long> productIds) { 
        em.getTransaction().begin();
        try {
            Customer c = em.find(Customer.class, customerId);
            Order o = new Order(); 
            o.setCustomer(c); 
            o.setOrderDate(new Date().toString());
            
            List<Product> products = new ArrayList<>();
            double total = 0;
            for(Long pid : productIds) {
                Product p = em.find(Product.class, pid);
                if(p != null) { 
                    products.add(p); 
                    total += p.getPrice(); 
                }
            }
            o.setProducts(products); 
            o.setTotalAmount(total);
            em.persist(o);
            em.getTransaction().commit();
        } catch(Exception e) { 
            em.getTransaction().rollback(); 
        }
    }
}
