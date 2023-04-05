package com.decagon.efashionplace.dto;


import com.decagon.efashionplace.entity.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartDto extends ProductDto {
    private long id;
    private int quantity;
    private String totalPrice;
}
