package com.decagon.efashionplace.service;

import com.decagon.efashionplace.entity.Product;
import com.decagon.efashionplace.entity.User;
import com.decagon.efashionplace.respository.ProductRepository;
import com.decagon.efashionplace.respository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AppService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    public Integer register(User userInfo) {
        List<User> UserInfoList =  new ArrayList<>();
        UserInfoList.add(userRepository.save(userInfo));
        return UserInfoList.size();
    }

    public List<User> checkLoginDetails(String email) {
        return userRepository.findByEmail(email);
    }

    public void registerProduct(Product product){
        List<Product> productList = new ArrayList<>();

        productList.add(productRepository.save(product));
    }
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
}
