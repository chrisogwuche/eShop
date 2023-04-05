package com.decagon.efashionplace.entity;

import com.decagon.efashionplace.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="product name")
    private String productName;
    @Column (name = "selling price")
    private String sellingPrice;
    @Column(name = "cost price")
    private String costPrice;
    @Column(name="file path")
    private String filePath;
    @Column(name ="quantity in stock")
    private String quantityInStock;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    public Product(String productName, String sellingPrice, String costPrice, String filePath, String quantityInStock, Category category){
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.filePath = filePath;
        this.quantityInStock = quantityInStock;
        this.category = category;
        this.createdAt = LocalDateTime.now();
        
    }

}
