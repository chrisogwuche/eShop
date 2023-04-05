package com.decagon.efashionplace.controller;

import com.decagon.efashionplace.dto.CartDto;
import com.decagon.efashionplace.entity.Product;
import com.decagon.efashionplace.service.AppService;
import com.decagon.efashionplace.service.ShoppingCartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class CartTabController {
//    private ArrayList<CartDto> cartList = new ArrayList<>();
    private static List<CartDto> cartList = new ArrayList<>();

    @Autowired
    ShoppingCartService cartService;
    @Autowired
    AppService appService;
    @Autowired
    private HttpServletRequest request;


    @GetMapping("/add-to-cart")
    public String showShoppingCart(@RequestParam("id") String productId, Model model){
        Long id = Long.parseLong(productId);


        HttpSession session = request.getSession();
        List<CartDto> cart_list = (ArrayList<CartDto>) session.getAttribute("cart-list");

        // To ensure that the id is 0 and to avoid an empty Entity return
        if(cart_list == null && id!=0 && id == getIntoCartList(id).getId()){

            cartList.add(getIntoCartList(id));
            session.setAttribute("cart-list", cartList);
        }

        if(cart_list!=null && id!=0 && id == getIntoCartList(id).getId()){
            cartList = cart_list;
            boolean exist = false;

            for(CartDto product: cartList){
                if(product.getId() == id){
                    exist = true;
                }
            }

            if(!exist){
                cartList.add(getIntoCartList(id));
            }
            else{
                log.info("i exist oo");
            }

        }
        return "redirect:/home";
    }

    public CartDto getIntoCartList(Long id){

        Product product = cartService.listCartItems(id);
        CartDto row = new CartDto();

        row.setId(id);
        row.setProductName(product.getProductName());
        row.setSellingPrice(product.getSellingPrice());
        row.setFilePath(product.getFilePath());
        row.setCategory(product.getCategory());
        row.setQuantity(1);
        row.setTotalPrice(String.valueOf
                (Double.valueOf(product.getSellingPrice())));


        return row;
    }

    public List<CartDto> getCartList(){
        return cartList;
    }
}
