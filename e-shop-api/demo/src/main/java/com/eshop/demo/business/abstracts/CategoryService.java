package com.eshop.demo.business.abstracts;

import java.util.List;

import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.dtos.CategoryDto;

public interface CategoryService {

    Result add(CategoryDto categoryDto);

    DataResult<List<CategoryDto>> getAllCategories();

    DataResult<List<CategoryDto>> getAllCategoriesSorted();

}
