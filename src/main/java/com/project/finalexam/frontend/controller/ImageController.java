package com.project.finalexam.frontend.controller;

import com.project.finalexam.backend.model.Image;
import com.project.finalexam.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("/user/image/{id}")
    public ResponseEntity<byte[]> getImg(@PathVariable("id")Integer id) {
        Image image = imageService.getImage(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(image.getData());
    }

    @PostMapping("/user/add-img")
    public void savImg(@RequestParam("file") MultipartFile file){
        imageService.saveImage(file);
    }
}
