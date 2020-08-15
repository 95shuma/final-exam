package com.project.finalexam.frontend.controller;

import com.project.finalexam.backend.model.Image;
import com.project.finalexam.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ImageService imageService;

    @GetMapping("/user/img")
    public String getIm(){
        return "imageAdd";
    }

    @GetMapping("/user/img/{id}")
    public String getImg(@PathVariable("id")Integer id, Model model) {
        model.addAttribute("img",imageService.getImage(id));
        return "image";
    }
}
