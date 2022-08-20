package com.example.biblioteca.repository;

import com.example.biblioteca.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
    //Optional<User> findUserByUsername(String username);
    Optional<User> findUsersByUsername(String username);
}
