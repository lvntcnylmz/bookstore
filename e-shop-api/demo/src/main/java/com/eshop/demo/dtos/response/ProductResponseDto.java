package com.eshop.demo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    
    private Long id;
    private String productName;
    private Double unitPrice;
    private Short unitsInStock;
    private String description;
    private Long categoryId;
    private String categoryCategoryName;

}
