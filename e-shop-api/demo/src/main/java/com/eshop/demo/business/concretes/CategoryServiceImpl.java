package com.eshop.demo.business.concretes;

import java.util.List;

import com.eshop.demo.business.abstracts.CategoryService;
import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessDataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessResult;
import com.eshop.demo.dataAccess.CategoryRepository;
import com.eshop.demo.dtos.request.CategoryRequestDto;
import com.eshop.demo.dtos.response.CategoryResponseDto;
import com.eshop.demo.entities.concretes.Category;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(CategoryRequestDto categoryRequest) {
        this.categoryRepository.save(this.convertToEntity(categoryRequest));
        return new SuccessResult("The category added.");
    }

    @Override
    public DataResult<List<CategoryResponseDto>> getAll() {
        return new SuccessDataResult<>(this.convertToDtoList(), "Categories are listed.");
    }

    @Override
    public DataResult<List<CategoryResponseDto>> getAllSorted() {
        return new SuccessDataResult<>(this.convertToDtoSortedList(), "Categories are listed.");
    }

    private Category convertToEntity(CategoryRequestDto categoryRequest) {
        return this.modelMapper.map(categoryRequest, Category.class);
    }

    private CategoryResponseDto convertToDto(Category category) {
        return this.modelMapper.map(category, CategoryResponseDto.class);
    }

    private List<CategoryResponseDto> convertToDtoList() {
        return this.categoryRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    private List<CategoryResponseDto> convertToDtoSortedList() {
        return this.categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryName"))
                .stream()
                .map(this::convertToDto)
                .toList();
    }

}
