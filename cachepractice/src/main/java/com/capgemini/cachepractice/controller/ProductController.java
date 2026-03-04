package com.capgemini.cachepractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cachepractice.entity.Product;
import com.capgemini.cachepractice.service.ProductService;

@RestController
public class ProductController {

	private ProductService service;
	
	
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
	@GetMapping("/find-id/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getById(id);
	}
	
}
