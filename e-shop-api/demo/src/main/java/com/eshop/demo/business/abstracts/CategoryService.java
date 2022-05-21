package com.eshop.demo.business.abstracts;

import java.util.List;

import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.entities.concretes.Category;

public interface CategoryService {

    Result add(Category category);

    DataResult<List<Category>> getAllCategories();

    DataResult<List<Category>> getAllCategoriesSorted();

}
