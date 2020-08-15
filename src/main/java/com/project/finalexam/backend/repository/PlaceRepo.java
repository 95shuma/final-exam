package com.project.finalexam.backend.repository;

import com.project.finalexam.backend.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<Place, Integer> {
}
