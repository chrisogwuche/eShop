package com.decagon.efashionplace.respository;

import com.decagon.efashionplace.dto.CartDto;
import com.decagon.efashionplace.entity.CartItem;
import com.decagon.efashionplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
    List<Product> findAll();

    public Product findById(long id);
}
