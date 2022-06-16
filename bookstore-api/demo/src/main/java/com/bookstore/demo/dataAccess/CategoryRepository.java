package com.bookstore.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.demo.entities.concretes.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
