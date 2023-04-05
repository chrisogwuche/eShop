package com.decagon.eshop.controller;

import com.decagon.eshop.Model.UserInfo;
import com.decagon.eshop.dto.RegisterationDto;
import com.decagon.eshop.enums.UserRole;
import com.decagon.eshop.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/")

public class RegistrationController {
    private RegistrationService registrationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String register(@ModelAttribute RegisterationDto user, Model model){
        model.addAttribute("userInfo",user);
        return  "register";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute RegisterationDto user){
        UserInfo userInfo =
                new UserInfo(user.getFirstName(),user.getLastName()
                        ,user.getEmail(),user.getPassword(), UserRole.USER);

        int count = registrationService.register(userInfo);

        if(count> 0){
            model.addAttribute("status", "success");
        }
        else{
            model.addAttribute("status","failed");
        }
        return "register";
    }
}
