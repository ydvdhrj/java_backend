package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class SQLQuery {

	public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
//		String sql="select * from product";
//		
//		Query query = em.createNativeQuery(sql);
//		
//		List<Product> list = query.getResultList();
		
//		String sql="update product set price=?1 where price>=?2";
//		et.begin();
//		Query query = em.createNativeQuery(sql);
//		
//		query.setParameter(1,50.0);
//		query.setParameter(2, 10.0);
		
		
		String sql="select p from Product p where p.price>=:a and p.quantity>=:b";
		
		Query query = em.createQuery(sql);
		
		query.setParameter("a",5.0);
		query.setParameter("b", 0);
		
		List<Product> list = query.getResultList();
		
		for(Product p:list) {
			System.out.println(p);
		}
		
		
		
		
	}
}
