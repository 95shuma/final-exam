package com.project.finalexam.backend.repository;

import com.project.finalexam.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepo extends JpaRepository <Image, Integer> {

    @Query(value="select * from images group by place_id", nativeQuery = true)
    List<Image> findAll();
}
