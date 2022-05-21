package com.eshop.demo.dataAccess;

import java.util.Optional;

import com.eshop.demo.entities.concretes.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductName(String productName);
}
