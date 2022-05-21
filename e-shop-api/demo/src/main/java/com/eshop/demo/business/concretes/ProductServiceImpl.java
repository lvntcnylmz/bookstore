package com.eshop.demo.business.concretes;

import java.util.List;

import com.eshop.demo.business.abstracts.ProductService;
import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessDataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessResult;
import com.eshop.demo.dataAccess.ProductRepository;
import com.eshop.demo.entities.concretes.Product;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("The product added.");
    }

    @Override
    public DataResult<List<Product>> getAllProducts() {
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(), "Products are listed.");
    }

    @Override
    public DataResult<List<Product>> getAllProductsSorted() {
        return new SuccessDataResult<List<Product>>(
                this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "productName")), "Products are listed.");
    }

    @Override
    public DataResult<Product> getByProductId(Long id) {
        return new SuccessDataResult<Product>(this.productRepository.findById(id).orElseThrow(),
                "The product has found.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productRepository.findByProductName(productName).orElseThrow(),
                "The product has found.");
    }

}
