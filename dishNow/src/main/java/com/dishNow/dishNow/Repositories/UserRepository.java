package com.dishNow.dishNow.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dishNow.dishNow.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}