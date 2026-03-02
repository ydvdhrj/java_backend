package com.example.__fab.Product.Category.Management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.__fab.Product.Category.Management.entity.Category;
import com.example.__fab.Product.Category.Management.entity.Product;
import com.example.__fab.Product.Category.Management.exceptions.CategoryNotFoundException;
import com.example.__fab.Product.Category.Management.exceptions.ProductNotFoundException;
import com.example.__fab.Product.Category.Management.repository.CategoryRepository;
import com.example.__fab.Product.Category.Management.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Long categoryId, Product product) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryCategoryId(categoryId);
    }

    public List<Product> searchByName(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}