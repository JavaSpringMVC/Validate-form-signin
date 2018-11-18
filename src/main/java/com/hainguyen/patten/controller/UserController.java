package com.hainguyen.patten.controller;

import com.hainguyen.patten.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping
    public String formSignin(Model model){
        model.addAttribute("user", new User());
        return "signin";
    }

    @PostMapping
    public String checkSignin(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "signin";
        }
        return "index";
    }
}
