package com.project.finalexam.backend.service;

import com.project.finalexam.backend.model.Image;
import com.project.finalexam.backend.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    ImageRepo imageRepo;

    /*public void saveImage(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Image image = Image
                    new Image(fileName,file.getContentType(),file.getBytes());
            imageRepo.save(image);
        } catch (IOException e) {
            System.out.println(e);
        }
    }*/

    public Image getImage(Integer id){
        return imageRepo.findById(id).get();
    }
}
