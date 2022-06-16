package com.bookstore.demo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.demo.business.abstracts.ProductService;
import com.bookstore.demo.dtos.request.ProductRequestDto;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProductRequestDto productRequest){
        return ResponseEntity.ok(this.productService.add(productRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping("/getAllSorted")
    public ResponseEntity<?> getAllProductsSorted(){
        return ResponseEntity.ok(this.productService.getAllSorted());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getByProductId(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.getById(id));
    }

    @GetMapping("/{productName}")
    public ResponseEntity<?> getByProductName(@PathVariable String productName){
        return ResponseEntity.ok(this.productService.getByName(productName));
    }

}