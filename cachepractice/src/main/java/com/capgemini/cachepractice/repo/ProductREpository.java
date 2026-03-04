package com.capgemini.cachepractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.cachepractice.entity.Product;


public interface ProductREpository extends JpaRepository<Product, Integer> {

}
  