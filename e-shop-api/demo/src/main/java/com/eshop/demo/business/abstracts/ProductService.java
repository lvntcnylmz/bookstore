package com.eshop.demo.business.abstracts;

import java.util.List;

import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.dtos.ProductDto;

public interface ProductService {
    
    Result add(ProductDto productDto);
    
    DataResult<List<ProductDto>> getAllProducts();

    DataResult<List<ProductDto>> getAllProductsSorted();
    
    DataResult<ProductDto> getByProductId(Long id);

    DataResult<ProductDto> getByProductName(String productName);

}
