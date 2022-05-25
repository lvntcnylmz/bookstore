package com.eshop.demo.dtos;

import com.eshop.demo.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String productName;
    private Double unitPrice;
    private Short unitsInStock;
    private String description;
    private Long categoryId;

}
