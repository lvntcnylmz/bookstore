package com.eshop.demo.dtos;

import java.util.List;

public record CategoryDto(
        Long id,
        String categroyName,
        List<ProductDto> products){
}
