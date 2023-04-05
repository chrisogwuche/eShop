package com.decagon.efashionplace.controller;


import com.decagon.efashionplace.dto.ProductDto;
import com.decagon.efashionplace.dto.UserDto;
import com.decagon.efashionplace.entity.Product;
import com.decagon.efashionplace.entity.User;
import com.decagon.efashionplace.enums.Category;
import com.decagon.efashionplace.enums.UserRole;
import com.decagon.efashionplace.service.AppService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    AppService appService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String goToRegister(Model model){
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @GetMapping("/login")
    public String GoToLogin(Model model){
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @GetMapping("/admin-page")
    public String goToAdminPage(Model model){
        model.addAttribute("adminProducts", new Product());
        return "admin_page";
    }

    @PostMapping("/addItems")
    public String addItem(@ModelAttribute ProductDto productDto, Model model){
        Product product = new Product(productDto.getProductName(),productDto.getSellingPrice(),productDto.getCostPrice(),
                productDto.getFilePath(),productDto.getQuantityInStock(), productDto.getCategory());

        appService.registerProduct(product);
        return "admin_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, Model model){

        if(userDto.getEmail() == null || userDto.getPassword()==null){
            model.addAttribute("status","failed");
            log.info("Email or Password is Null");
            return "login";
        }

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        List<User> result = appService.checkLoginDetails(user.getEmail());
//        log.info("Optional :" +result.toString());

        if( !result.isEmpty() && result.get(0).getPassword().equals(user.getPassword())){
            model.addAttribute("userName", result.get(0).getFirstName());
            HttpSession session = request.getSession();
            session.setAttribute("name",result.get(0).getFirstName());

            return "redirect:/home";
        }
        else{
            model.addAttribute("status", "failed");
            return "login";
        }

    }

    @PostMapping("/register")
    public String registration(@ModelAttribute UserDto userDto, Model model){

        User user = new User(userDto.getFirstName(), userDto.getLastName(),
                        userDto.getEmail(),userDto.getPassword(),UserRole.USER);

        int count = appService.register(user);

        if(count>0){
            model.addAttribute("status","success");
        }
        else{
            model.addAttribute("status","failed");
        }

        return "register";
    }


}
