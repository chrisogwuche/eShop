package com.decagon.efashionplace.controller;


import com.decagon.efashionplace.dto.CartDto;
import com.decagon.efashionplace.entity.Product;
import com.decagon.efashionplace.enums.Category;
import com.decagon.efashionplace.service.AppService;
import com.decagon.efashionplace.service.ShoppingCartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    AppService appService;
    @Autowired
    ShoppingCartService cartService;
    @Autowired
    CartTabController cartTabController;


    @GetMapping("/home")
    public String goToHome(Model model){

        List<Product> productList = appService.findAllProducts();
        List<Product> menList = new ArrayList<>();
        List<Product> ladiesList = new ArrayList<>();
        List<Product> kidsList = new ArrayList<>();


        for(Product prod: productList){
            if(prod.getCategory().equals(Category.MEN)){
                menList.add(prod);
            }
            if(prod.getCategory().equals(Category.LADIES)){
                ladiesList.add(prod);
            }
            if(prod.getCategory().equals(Category.KIDS)){
                kidsList.add(prod);

            }
        }
        List<CartDto> cartList = cartTabController.getCartList();
        Double totalPrice = 0.0;

        for(CartDto prod: cartList){
            totalPrice += Double.parseDouble(prod.getTotalPrice());
        }


        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("cartList",cartList);
        model.addAttribute("menList", menList);
        model.addAttribute("ladiesList", ladiesList);
        model.addAttribute("kidsList", kidsList);

        return "home";
    }

}
