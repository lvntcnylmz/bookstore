package com.bookstore.demo.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.demo.entities.concretes.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
    
}
