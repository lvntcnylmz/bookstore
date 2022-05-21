package com.eshop.demo.api.controller;

import com.eshop.demo.business.abstracts.CategoryService;
import com.eshop.demo.entities.concretes.Category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category product){
        return ResponseEntity.ok(this.categoryService.add(product));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @GetMapping("/getAllSorted")
    public ResponseEntity<?> getAllCategoriesSorted(){
        return ResponseEntity.ok(this.categoryService.getAllCategoriesSorted());
    }

}
