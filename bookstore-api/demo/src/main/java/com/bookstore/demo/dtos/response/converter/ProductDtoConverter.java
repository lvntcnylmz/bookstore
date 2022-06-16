package com.bookstore.demo.dtos.response.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bookstore.demo.dtos.response.ProductResponseDto;
import com.bookstore.demo.entities.concretes.Product;

@Component
public class ProductDtoConverter {

    public static ProductResponseDto entityToDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getProductName(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getDescription(),
                product.getCategory().getId(),
                product.getCategory().getCategoryName());
    }

    public static List<ProductResponseDto> entityToDtoList(List<Product> product) {
        return product.stream()
                .map(p -> new ProductResponseDto(
                        p.getId(),
                        p.getProductName(),
                        p.getUnitPrice(),
                        p.getUnitsInStock(),
                        p.getDescription(),
                        p.getCategory().getId(),
                        p.getCategory().getCategoryName()))
                .toList();
    }

}
