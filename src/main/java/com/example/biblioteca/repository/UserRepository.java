package com.example.biblioteca.repository;

import com.example.biblioteca.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity,Long> {
    //Optional<User> findUserByUsername(String username);
    Optional<UserEntity> findUserEntitiesByUsername(String username);
}
