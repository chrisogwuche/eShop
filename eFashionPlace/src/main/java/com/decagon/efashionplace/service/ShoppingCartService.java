package com.decagon.efashionplace.service;

import com.decagon.efashionplace.entity.Product;
import com.decagon.efashionplace.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService {
    @Autowired
    ProductRepository productRepository;

    public Product listCartItems(long id){
        return productRepository.findById(id);
    }
}
