package com.eshop.demo.dtos.converter;

import java.util.List;

import com.eshop.demo.dtos.CategoryDto;
import com.eshop.demo.dtos.ProductDto;
import com.eshop.demo.entities.concretes.Category;
import com.eshop.demo.entities.concretes.Product;

public class CategoryDtoConverter {

    public CategoryDto convert(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getCategoryName(),
                productDtos(category.getProducts()));
    }

    private List<ProductDto> productDtos(List<Product> products) {
        return products.stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getProductName(),
                        p.getUnitPrice(),
                        p.getUnitsInStock(),
                        p.getDescription(),
                        p.getCategory().getCategoryName()))
                .toList();
    }

}
