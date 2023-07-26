package com.webcrudapi.controller;
import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;
import com.webcrudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String findAll(Model model){
        List<UserDto> listUsers = service.findAll();
        model.addAttribute("listUsers",listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewFrom(Model model){
        model.addAttribute("userenti",new UserEntity());
        model.addAttribute("pageTitle","Add new User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String save(UserEntity userEntity, RedirectAttributes ra){
        service.creat(userEntity);
        ra.addFlashAttribute("message","The user has been saved successfully.");
        return "redirect:/users";
    }


}
