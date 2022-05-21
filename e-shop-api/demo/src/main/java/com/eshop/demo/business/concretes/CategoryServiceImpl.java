package com.eshop.demo.business.concretes;

import java.util.List;

import com.eshop.demo.business.abstracts.CategoryService;
import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessDataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessResult;
import com.eshop.demo.dataAccess.CategoryRepository;
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
    public Result add(Category category) {
        this.categoryRepository.save(category);
        return new SuccessResult("The category added.");
    }

    @Override
    public DataResult<List<Category>> getAllCategories() {
        return new SuccessDataResult<List<Category>>(this.categoryRepository.findAll(), "Categories are listed.");
    }

    @Override
    public DataResult<List<Category>> getAllCategoriesSorted() {
        return new SuccessDataResult<List<Category>>(
                this.categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "categoryName")),
                "Categories are listed.");
    }

}
