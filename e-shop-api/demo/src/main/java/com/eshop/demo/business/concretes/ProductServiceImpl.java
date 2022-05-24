package com.eshop.demo.business.concretes;

import java.util.List;

import com.eshop.demo.business.abstracts.ProductService;
import com.eshop.demo.core.utils.config.ModelMapperConfig;
import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessDataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessResult;
import com.eshop.demo.dataAccess.ProductRepository;
import com.eshop.demo.dtos.ProductDto;
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
    public Result add(ProductDto productDto) {
        this.productRepository.save(this.convert(productDto));
        return new SuccessResult("The product added.");
    }

    @Override
    public DataResult<List<ProductDto>> getAllProducts() {
        return new SuccessDataResult<>(this.convertToDtoList(), "Products are listed.");
    }

    @Override
    public DataResult<List<ProductDto>> getAllProductsSorted() {
        return new SuccessDataResult<>(this.convertToDtoSortedList(), "Products are listed.");
    }

    @Override
    public DataResult<ProductDto> getByProductId(Long id) {

        Product product = this.productRepository.findById(id).orElseThrow();
        
        return new SuccessDataResult<>(this.convertToDto(product), "The product has found.");
    }

    @Override
    public DataResult<ProductDto> getByProductName(String productName) {

        Product product = this.productRepository.findByProductName(productName).orElseThrow();

        return new SuccessDataResult<>(this.convertToDto(product), "The product has found.");
    }

    private Product convert(ProductDto productDto) {
        return ModelMapperConfig.modelMapper().map(productDto, Product.class);
    }

    private ProductDto convertToDto(Product product) {
        return ModelMapperConfig.modelMapper().map(product, ProductDto.class);
    }

    private List<ProductDto> convertToDtoList() {
        return this.productRepository.findAll()
                .stream()
                .map(product -> this.convertToDto(product))
                .toList();
    }

    private List<ProductDto> convertToDtoSortedList() {
        return this.productRepository.findAll(Sort.by(Sort.Direction.DESC, "productName"))
                .stream()
                .map(product -> this.convertToDto(product))
                .toList();
    }

}
