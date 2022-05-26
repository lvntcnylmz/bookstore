package com.eshop.demo.business.concretes;

import java.util.List;

import com.eshop.demo.business.abstracts.ProductService;
import com.eshop.demo.core.utils.results.abstracts.Result;
import com.eshop.demo.core.utils.results.concretes.DataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessDataResult;
import com.eshop.demo.core.utils.results.concretes.SuccessResult;
import com.eshop.demo.dataAccess.ProductRepository;
import com.eshop.demo.dtos.request.ProductRequestDto;
import com.eshop.demo.dtos.response.ProductResponseDto;
import com.eshop.demo.entities.concretes.Product;

import com.eshop.demo.exceptions.ProductNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(ProductRequestDto productRequest) {
        this.productRepository.save(this.convertToEntity(productRequest));
        return new SuccessResult("The product added.");
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAll() {
        return new SuccessDataResult<>(this.convertToDtoList(), "Products are listed.");
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAllSorted() {
        return new SuccessDataResult<>(this.convertToDtoSortedList(), "Products are listed.");
    }

    @Override
    public DataResult<ProductResponseDto> getByProductId(Long id) {

        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product could not found by id : " + id));
        
        return new SuccessDataResult<>(this.convertToDto(product), "The product has found.");
    }

    @Override
    public DataResult<ProductResponseDto> getByProductName(String productName) {

        Product product = this.productRepository.findByProductName(productName)
                .orElseThrow(() -> new ProductNotFoundException("Product could not found by product name : " + productName));

        return new SuccessDataResult<>(this.convertToDto(product), "The product has found.");
    }

    private Product convertToEntity(ProductRequestDto productRequest) {
        return this.modelMapper.map(productRequest, Product.class);
    }

    private ProductResponseDto convertToDto(Product product) {
        return this.modelMapper.map(product, ProductResponseDto.class);
    }

    private List<ProductResponseDto> convertToDtoList() {
        return this.productRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    private List<ProductResponseDto> convertToDtoSortedList() {
        return this.productRepository.findAll(Sort.by(Sort.Direction.ASC, "productName"))
                .stream()
                .map(this::convertToDto)
                .toList();
    }

}
