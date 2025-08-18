package com.dishNow.dishNow.Config;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dishNow.dishNow.Enums.UserEnums.USER_ROLE;
import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Repositories.UserRepository;

@Configuration
public class AdminUserInitializer {
    
    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
        String adminEmail = "admin@admin.com";

        if (!userRepository.existsByEmail(adminEmail)) {
            User admin = new User();
            admin.setEmail(adminEmail);
            admin.setPasswordHash(passwordEncoder.encode("admin123"));
            admin.setRole(USER_ROLE.ADMIN);
            admin.setName("admin");
            admin.setLastName("admin");
            admin.setBirthday(LocalDate.now());
            admin.setVerified(true);
            admin.setFavoriteRecipes(new ArrayList<>());
            admin.setRecipesCreated(new ArrayList<>());
            userRepository.save(admin);

            System.out.println("✅ Admin user created with email: " + adminEmail);
        } else {
            System.out.println("ℹ️ Admin user already exists.");
        }
    };
    }
}
