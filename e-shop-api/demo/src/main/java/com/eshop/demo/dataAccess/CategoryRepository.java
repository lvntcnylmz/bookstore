package com.eshop.demo.dataAccess;

import com.eshop.demo.entities.concretes.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
