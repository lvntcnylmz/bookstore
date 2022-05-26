package com.eshop.demo.dtos.response.converter;

import java.util.List;

import com.eshop.demo.dtos.response.CategoryResponseDto;
import com.eshop.demo.entities.concretes.Category;

import org.springframework.stereotype.Component;

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
