package com.project.finalexam.backend.repository;

import com.project.finalexam.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
