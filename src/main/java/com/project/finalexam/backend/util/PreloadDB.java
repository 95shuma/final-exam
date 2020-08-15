package com.project.finalexam.backend.util;

import com.project.finalexam.backend.model.User;
import com.project.finalexam.backend.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PreloadDB {
    private final PasswordEncoder encoder;

    public PreloadDB(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Bean
    CommandLineRunner initDatabase(UserRepo ur) {
        return (args) -> {
            ur.deleteAll();
            User user = User.builder()
                    .name("user")
                    .password(encoder.encode("user"))
                    .build();
            ur.save(user);

            System.out.println("http://localhost:7777/");
        };
    }
}
