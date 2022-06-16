package com.bookstore.demo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.demo.business.abstracts.CategoryService;
import com.bookstore.demo.dtos.request.CategoryRequestDto;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CategoryRequestDto categoryRequest){
        return ResponseEntity.ok(this.categoryService.add(categoryRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getAll());
    }

    @GetMapping("/getAllSorted")
    public ResponseEntity<?> getAllCategoriesSorted(){
        return ResponseEntity.ok(this.categoryService.getAllSorted());
    }

}
