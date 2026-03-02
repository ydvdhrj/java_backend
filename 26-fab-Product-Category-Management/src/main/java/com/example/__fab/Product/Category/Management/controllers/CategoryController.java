package com.example.__fab.Product.Category.Management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.__fab.Product.Category.Management.entity.Category;
import com.example.__fab.Product.Category.Management.repository.CategoryRepository;
import com.example.__fab.Product.Category.Management.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    
    @Autowired
	 CategoryRepository categoryjpa;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
    
//    @GetMapping("/categories/{page}/{size}")
//    public Page<Category> getCategory(int page, int size) {
//    	Page<Category> p = categoryService.findAll(page, size);
//    	return p;
//    }
    
    @GetMapping("/categories/{page}/{size}")
	public List<Category> getCategory(@PathVariable int page,@PathVariable int size) {
		
		Page<Category> p=categoryjpa.findAll(PageRequest
				.of(page, size,Sort.by("id").descending()));
		
		return p.getContent();
	}
    
    
    @GetMapping("/get-id/{id}")
    public ResponseEntity<Category> getById(@PathVariable long id){
    	Optional<Category> optional = categoryjpa.findById(id);
    	Category c = null;
    	if(optional.isPresent()) {
    		c= optional.get();
    		return new ResponseEntity<Category>(c,HttpStatus.FOUND);
    	}else {
    		return new ResponseEntity<Category>(c, HttpStatus.NOT_FOUND);
    	}
    }
}