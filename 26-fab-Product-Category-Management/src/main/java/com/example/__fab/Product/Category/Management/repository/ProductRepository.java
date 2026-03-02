package com.example.__fab.Product.Category.Management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.__fab.Product.Category.Management.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryCategoryId(Long categoryId);

    List<Product> findByProductNameContainingIgnoreCase(String name);
}
