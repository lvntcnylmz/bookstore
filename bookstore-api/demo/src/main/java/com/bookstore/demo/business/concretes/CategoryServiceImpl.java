package com.bookstore.demo.business.concretes;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookstore.demo.business.abstracts.CategoryService;
import com.bookstore.demo.core.utils.messages.Message;
import com.bookstore.demo.core.utils.results.abstracts.Result;
import com.bookstore.demo.core.utils.results.concretes.DataResult;
import com.bookstore.demo.core.utils.results.concretes.SuccessDataResult;
import com.bookstore.demo.core.utils.results.concretes.SuccessResult;
import com.bookstore.demo.dataAccess.CategoryRepository;
import com.bookstore.demo.dtos.request.CategoryRequestDto;
import com.bookstore.demo.dtos.response.CategoryResponseDto;
import com.bookstore.demo.dtos.response.converter.CategoryDtoConverter;
import com.bookstore.demo.entities.concretes.Category;
import com.bookstore.demo.exceptions.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Result add(CategoryRequestDto categoryRequest) {
        this.categoryRepository.save(this.convertToEntity(categoryRequest));
        return new SuccessResult(Message.SAVED);
    }

    @Override
    public DataResult<List<CategoryResponseDto>> getAll() {
        return new SuccessDataResult<>(this.convertToDtoList(), Message.LISTED);
    }

    @Override
    public DataResult<List<CategoryResponseDto>> getAllSorted() {
        return new SuccessDataResult<>(this.convertToDtoSortedList(), Message.LISTED);
    }

    @Override
    public DataResult<CategoryResponseDto> getById(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(Message.NOT_FOUND_BY_ID));

        return new SuccessDataResult<CategoryResponseDto>(this.convertToDto(category), Message.FOUND_BY_ID);
    }

    private Category convertToEntity(CategoryRequestDto categoryRequest) {
        return new Category(categoryRequest.getCategoryName(), Collections.emptyList());
    }

    private CategoryResponseDto convertToDto(Category category) {
        return CategoryDtoConverter.entityToDto(category);
    }

    private List<CategoryResponseDto> convertToDtoList() {
        return CategoryDtoConverter.entityToDtoList(this.categoryRepository.findAll());
    }

    private List<CategoryResponseDto> convertToDtoSortedList() {
        return CategoryDtoConverter
                .entityToDtoList(this.categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryName")));
    }

}
