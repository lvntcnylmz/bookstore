package com.bookstore.demo.business.abstracts;

import java.util.List;

import com.bookstore.demo.core.utils.results.abstracts.Result;
import com.bookstore.demo.core.utils.results.concretes.DataResult;
import com.bookstore.demo.dtos.request.CategoryRequestDto;
import com.bookstore.demo.dtos.response.CategoryResponseDto;

public interface CategoryService {

    Result add(CategoryRequestDto categoryDto);

    DataResult<List<CategoryResponseDto>> getAll();

    DataResult<List<CategoryResponseDto>> getAllSorted();

    DataResult<CategoryResponseDto> getById(Long id);

}
