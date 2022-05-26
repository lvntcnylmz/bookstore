package com.eshop.demo.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    
    private String productName;
    private Double unitPrice;
    private Short unitsInStock;
    private String description;
    private Long categoryId;

}
