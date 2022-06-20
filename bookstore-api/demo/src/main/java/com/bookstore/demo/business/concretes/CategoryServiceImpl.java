package com.bookstore.demo.business.concretes;

import org.springframework.stereotype.Service;

import com.bookstore.demo.business.abstracts.CategoryService;
import com.bookstore.demo.dataAccess.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

}
