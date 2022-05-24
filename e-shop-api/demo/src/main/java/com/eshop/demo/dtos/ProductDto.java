package com.eshop.demo.dtos;

public record ProductDto(
        Long id,
        String productName,
        Double unitPrice,
        Short unitsInStock,
        String description,
        String categoryName) {
}
