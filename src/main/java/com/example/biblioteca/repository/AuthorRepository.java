package com.example.biblioteca.repository;

import com.example.biblioteca.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
