package com.project.finalexam.frontend.controller;

import com.project.finalexam.backend.model.Image;
import com.project.finalexam.backend.model.User;
import com.project.finalexam.backend.repository.UserRepo;
import com.project.finalexam.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ImageService imageService;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/user/img")
    public String getIm(){
        return "imageAdd";
    }

    @GetMapping("/")
    public String getMainPage(Model model, Principal principal){
        try{
            User user = userRepo.findUserByName(principal.getName()).get();
            model.addAttribute("user",user);
        }catch (Exception e){
        }
        return "index";
    }


    @GetMapping("/user/img/{id}")
    public String getImg(@PathVariable("id")Integer id, Model model) {
        model.addAttribute("img",imageService.getImage(id));
        return "image";
    }
}
