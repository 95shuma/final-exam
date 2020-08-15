package com.project.finalexam.backend.repository;

import com.project.finalexam.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
    List<Review> findReviewsByPlaceId(Integer id);

    Optional<Review> findReviewByPlaceId(Integer id);
}
