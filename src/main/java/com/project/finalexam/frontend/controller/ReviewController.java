package com.project.finalexam.frontend.controller;

import com.project.finalexam.backend.model.Image;
import com.project.finalexam.backend.model.Review;
import com.project.finalexam.backend.model.User;
import com.project.finalexam.backend.repository.ImageRepo;
import com.project.finalexam.backend.repository.PlaceRepo;
import com.project.finalexam.backend.repository.ReviewRepo;
import com.project.finalexam.backend.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class ReviewController {

    private UserRepo userRepo;
    private ImageRepo imageRepo;
    private PlaceRepo placeRepo;
    private ReviewRepo reviewRepo;

    @GetMapping("/place/{id}")
    public String getPlace(@PathVariable("id")Integer id, Model model, Principal principal){

        try{
            User user = userRepo.findUserByName(principal.getName()).get();
            model.addAttribute("user",user);
        }catch (Exception e){
        }

        model.addAttribute("place",placeRepo.findById(id).get());
        model.addAttribute("image",imageRepo.findImageByPlaceId(id).get());
        model.addAttribute("images",imageRepo.findImagesByPlaceId(id));
        try{
            model.addAttribute("review", reviewRepo.findReviewByPlaceId(id).get());
            model.addAttribute("reviews",reviewRepo.findReviewsByPlaceId(id));
        } catch (Exception e) {
        }
        return "reviews";
    }

    @PostMapping("/user/add-review")
    public String addRev(@RequestParam("user_id") Integer user_id,
                         @RequestParam("place_id") Integer place_id,
                         @RequestParam("review") String review,
                         @RequestParam("rating") Integer rating){

        Review review1 = Review.builder()
                .user(userRepo.findById(user_id).get())
                .place(placeRepo.findById(place_id).get())
                .review(review)
                .rating(rating)
                .build();
        reviewRepo.save(review1);
        return "redirect:/place/"+place_id;
    }

    @PostMapping("/user/add-image")
    public String addImg(@RequestParam("place_id") Integer place_id,
                         @RequestParam("file")MultipartFile file){
        try {
            Image image = new Image(StringUtils.cleanPath(file.getOriginalFilename()),
                    file.getContentType(), file.getBytes(), placeRepo.findById(place_id).get());
            imageRepo.save(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/place/"+place_id;
    }
}
