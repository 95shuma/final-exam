package com.project.finalexam.frontend.controller;

import com.project.finalexam.backend.model.Image;
import com.project.finalexam.backend.model.Place;
import com.project.finalexam.backend.repository.ImageRepo;
import com.project.finalexam.backend.repository.PlaceRepo;
import com.project.finalexam.backend.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class PlaceController {

    private PlaceRepo placeRepo;
    private ImageRepo imageRepo;
    private UserRepo userRepo;

    @GetMapping("/add-place")
    public String addPlace(Model model, Principal principal){
        model.addAttribute("user",userRepo.findUserByName(principal.getName()).get());
        return "addPlace";
    }

    @PostMapping("/add-place")
    public String addNewPlace(@RequestParam("name")String name,
                            @RequestParam("description") String description,
                            @RequestParam("file")MultipartFile file){
        Place place = Place.builder()
                .name(name)
                .description(description)
                .build();
        placeRepo.save(place);
        try {
            Image image = new Image(StringUtils.cleanPath(file.getOriginalFilename()),
                    file.getContentType(), file.getBytes(), place);
            imageRepo.save(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
