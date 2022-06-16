package com.bookstore.demo.business.abstracts;

import java.util.List;

import com.bookstore.demo.core.utils.results.abstracts.Result;
import com.bookstore.demo.core.utils.results.concretes.DataResult;
import com.bookstore.demo.dtos.request.ProductRequestDto;
import com.bookstore.demo.dtos.response.ProductResponseDto;

public interface ProductService {
    
    Result add(ProductRequestDto product);
    
    DataResult<List<ProductResponseDto>> getAll();

    DataResult<List<ProductResponseDto>> getAllSorted();
    
    DataResult<ProductResponseDto> getById(Long id);

    DataResult<ProductResponseDto> getByName(String productName);

}
