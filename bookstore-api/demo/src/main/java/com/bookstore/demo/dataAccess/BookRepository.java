package com.bookstore.demo.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.demo.entities.concretes.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {
    
}
