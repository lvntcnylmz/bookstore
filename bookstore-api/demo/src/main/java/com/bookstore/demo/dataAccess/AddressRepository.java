package com.bookstore.demo.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.demo.entities.concretes.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    
}
