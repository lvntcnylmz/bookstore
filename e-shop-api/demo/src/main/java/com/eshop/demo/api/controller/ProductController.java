package com.eshop.demo.api.controller;

import com.eshop.demo.business.abstracts.ProductService;
import com.eshop.demo.dtos.ProductDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProductDto product){
        return ResponseEntity.ok(this.productService.add(product));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @GetMapping("/getAllSorted")
    public ResponseEntity<?> getAllProductsSorted(){
        return ResponseEntity.ok(this.productService.getAllProductsSorted());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getByProductId(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.getByProductId(id));
    }

    @GetMapping("/{productName}")
    public ResponseEntity<?> getByProductName(@PathVariable String productName){
        return ResponseEntity.ok(this.productService.getByProductName(productName));
    }

}
