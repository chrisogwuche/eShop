package com.decagon.efashionplace.dto;

import com.decagon.efashionplace.enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String productName;
    private String sellingPrice;
    private String costPrice;
    private String filePath;
    private String quantityInStock;
    private Category category;

}
