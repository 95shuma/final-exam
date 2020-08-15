package com.project.finalexam.backend.repository;

import com.project.finalexam.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository <Image, Integer> {
}
