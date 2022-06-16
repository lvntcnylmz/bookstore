package com.bookstore.demo.dtos.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    
    private UUID id;
    private String productName;
    private Double unitPrice;
    private Short unitsInStock;
    private String description;
    private Long categoryId;
    private String categoryName;

}
