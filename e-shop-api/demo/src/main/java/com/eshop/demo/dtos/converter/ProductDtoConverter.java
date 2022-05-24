package com.eshop.demo.dtos.converter;

import com.eshop.demo.dtos.ProductDto;
import com.eshop.demo.entities.concretes.Product;

public class ProductDtoConverter {

    public ProductDto convert(Product product) {
        return new ProductDto(product.getId(),
                product.getProductName(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getDescription(),
                product.getCategory().getCategoryName());
    }

}
