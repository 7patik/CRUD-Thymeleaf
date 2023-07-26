package com.webcrudapi.controller;

import com.webcrudapi.model.dto.UserDto;
import com.webcrudapi.model.entity.UserEntity;
import com.webcrudapi.service.AdminService;
import com.webcrudapi.service.UserNotFoundExcemtion;
import com.webcrudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class AdminController {
    @Autowired
    private AdminService service;
    @GetMapping("/admin")
    public String findAll(Model model){
        List<UserEntity> listUsers = service.findAll();
        model.addAttribute("listUsers",listUsers);
        return "admin";
    }
    @GetMapping("/users/edit/{id}")
    public String updatefromusers(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes ra) {
        try{
            UserEntity user = service.update(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Update User"+id+")");
            return "admin_form";
        }catch (UserNotFoundExcemtion e){
            e.printStackTrace();
        }
        ra.addFlashAttribute("message","The user has been saved successfully.");
        return "redirect:/users";
    }
    @GetMapping("/users/new/admin")
    public String showNewFrom(Model model){
        model.addAttribute("userentity",new UserEntity());
        model.addAttribute("pageTitle","Add new User");
        return "admin_form";
    }
    @PostMapping("/users/save/admin")
    public String save(UserEntity userEntity, RedirectAttributes ra){
        service.creat(userEntity);
        ra.addFlashAttribute("message","The user has been saved successfully.");
        return "redirect:/admin";
    }
    @GetMapping("/users/delete/{id}")
    public String deletefromusers(@PathVariable(name = "id") Integer id, RedirectAttributes ra) {

        Boolean exist = service.exist(id);
        if (exist) {
            service.delete(id);
            ra.addFlashAttribute("massage","Person was deleted id-"+id);
            return "redirect:/admin";}
            else{
                ra.addFlashAttribute("message", "Could not find any users with id");
                return "redirect:/admin_form";
            }
    }

}
