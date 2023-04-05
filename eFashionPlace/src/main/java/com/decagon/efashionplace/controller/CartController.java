package com.decagon.efashionplace.controller;

import com.decagon.efashionplace.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartTabController cartTabController;
    @GetMapping("/cart")
    public String goToCart(Model model){
        List<CartDto> cartList = cartTabController.getCartList();

        Double totalPrice = 0.0;

        for(CartDto prod: cartList){
            totalPrice += Double.parseDouble(prod.getTotalPrice());
        }


        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("cartList",cartList);

        return "cart";
    }
}
