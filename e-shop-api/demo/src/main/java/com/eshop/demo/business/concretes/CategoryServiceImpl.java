package com.eshop.demo.business.concretes;

import java.util.List;

import com.eshop.demo.business.abstracts.CategoryService;
import com.eshop.demo.core.utils.config.ModelMapperConfig;
import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessDataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessResult;
import com.eshop.demo.dataAccess.CategoryRepository;
import com.eshop.demo.dtos.CategoryDto;
import com.eshop.demo.entities.concretes.Category;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Result add(CategoryDto categoryDto) {
        this.categoryRepository.save(this.convert(categoryDto));
        return new SuccessResult("The category added.");
    }

    @Override
    public DataResult<List<CategoryDto>> getAllCategories() {
        return new SuccessDataResult<>(this.convertToDtoList(), "Categories are listed.");
    }

    @Override
    public DataResult<List<CategoryDto>> getAllCategoriesSorted() {
        return new SuccessDataResult<>(this.convertToDtoSortedList(), "Categories are listed.");
    }

    private Category convert(CategoryDto categoryDto) {
        return ModelMapperConfig.modelMapper().map(categoryDto, Category.class);
    }

    private CategoryDto convertToDto(Category category) {
        return ModelMapperConfig.modelMapper().map(category, CategoryDto.class);
    }

    private List<CategoryDto> convertToDtoList() {
        return this.categoryRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    private List<CategoryDto> convertToDtoSortedList() {
        return this.categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryName"))
                .stream()
                .map(this::convertToDto)
                .toList();
    }

}
