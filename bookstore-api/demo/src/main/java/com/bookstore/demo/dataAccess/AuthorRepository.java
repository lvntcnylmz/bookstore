package com.bookstore.demo.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.demo.entities.concretes.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    
}
