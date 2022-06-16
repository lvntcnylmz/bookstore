package com.bookstore.demo.dtos.response.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bookstore.demo.dtos.response.CategoryResponseDto;
import com.bookstore.demo.entities.concretes.Category;

@Component
public class CategoryDtoConverter {

    public static CategoryResponseDto entityToDto(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getCategoryName());
    }

    public static List<CategoryResponseDto> entityToDtoList(List<Category> categories) {
        return categories.stream()
                .map(c -> new CategoryResponseDto(
                        c.getId(),
                        c.getCategoryName()))
                .toList();
    }

}
