package com.project.finalexam.backend.repository;

import com.project.finalexam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
