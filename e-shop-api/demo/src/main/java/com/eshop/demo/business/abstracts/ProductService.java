package com.eshop.demo.business.abstracts;

import java.util.List;

import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.entities.concretes.Product;

public interface ProductService {
    
    Result add(Product product);
    
    DataResult<List<Product>> getAllProducts();

    DataResult<List<Product>> getAllProductsSorted();
    
    DataResult<Product> getByProductId(Long id);

    DataResult<Product> getByProductName(String productName);

}
