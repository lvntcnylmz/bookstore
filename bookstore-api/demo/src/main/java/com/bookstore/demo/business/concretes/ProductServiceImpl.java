package com.bookstore.demo.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookstore.demo.business.abstracts.ProductService;
import com.bookstore.demo.core.utils.messages.Message;
import com.bookstore.demo.core.utils.results.abstracts.Result;
import com.bookstore.demo.core.utils.results.concretes.DataResult;
import com.bookstore.demo.core.utils.results.concretes.SuccessDataResult;
import com.bookstore.demo.core.utils.results.concretes.SuccessResult;
import com.bookstore.demo.dataAccess.CategoryRepository;
import com.bookstore.demo.dataAccess.ProductRepository;
import com.bookstore.demo.dtos.request.ProductRequestDto;
import com.bookstore.demo.dtos.response.ProductResponseDto;
import com.bookstore.demo.dtos.response.converter.ProductDtoConverter;
import com.bookstore.demo.entities.concretes.Category;
import com.bookstore.demo.entities.concretes.Product;
import com.bookstore.demo.exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Result add(ProductRequestDto productRequest) {
        this.productRepository.save(this.convertToEntity(productRequest));
        return new SuccessResult(Message.SAVED);
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAll() {
        return new SuccessDataResult<>(this.convertToDtoList(), Message.LISTED);
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAllSorted() {
        return new SuccessDataResult<>(this.convertToDtoSortedList(), Message.LISTED);
    }

    @Override
    public DataResult<ProductResponseDto> getById(Long id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(Message.NOT_FOUND_BY_ID));

        return new SuccessDataResult<>(this.convertToDto(product), Message.FOUND_BY_ID);
    }

    @Override
    public DataResult<ProductResponseDto> getByName(String productName) {
        Product product = this.productRepository.findByProductName(productName)
                .orElseThrow(() -> new ProductNotFoundException(Message.NOT_FOUND_BY_NAME));

        return new SuccessDataResult<>(this.convertToDto(product), Message.FOUND_BY_NAME);
    }

    private Product convertToEntity(ProductRequestDto productRequest) {
        Category category = this.categoryRepository.getById(productRequest.getCategoryId());

        return new Product(
                productRequest.getProductName(),
                productRequest.getUnitPrice(),
                productRequest.getUnitsInStock(),
                productRequest.getDescription(),
                category);
    }

    private ProductResponseDto convertToDto(Product product) {
        return ProductDtoConverter.entityToDto(product);
    }

    private List<ProductResponseDto> convertToDtoList() {
        return ProductDtoConverter.entityToDtoList(this.productRepository.findAll());
    }

    private List<ProductResponseDto> convertToDtoSortedList() {
        return ProductDtoConverter
                .entityToDtoList(this.productRepository.findAll(Sort.by(Sort.Direction.ASC, "productName")));
    }

}
