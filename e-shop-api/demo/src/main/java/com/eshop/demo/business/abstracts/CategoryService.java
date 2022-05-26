package com.eshop.demo.business.abstracts;

import java.util.List;

import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.dtos.request.CategoryRequestDto;
import com.eshop.demo.dtos.response.CategoryResponseDto;

public interface CategoryService {

    Result add(CategoryRequestDto categoryDto);

    DataResult<List<CategoryResponseDto>> getAll();

    DataResult<List<CategoryResponseDto>> getAllSorted();

}
