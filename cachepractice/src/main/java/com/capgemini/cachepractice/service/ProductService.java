package com.capgemini.cachepractice.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.capgemini.cachepractice.entity.Product;
import com.capgemini.cachepractice.repo.ProductREpository;

@Service
public class ProductService {

	private ProductREpository repository;
	
	
	public ProductService(ProductREpository repository) {
		super();
		this.repository = repository;
	}

	@CachePut(cacheNames = "product", key="#result.id")
	public Product addProduct(Product p) {
		return repository.save(p);
	}
	
	@Cacheable(cacheNames = "product", key="#id")
	public Product getById(int id) {
		return repository.findById(id).orElseThrow(()->new RuntimeException("Data is not present"));
	}
}
