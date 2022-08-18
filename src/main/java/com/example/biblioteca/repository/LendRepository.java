package com.example.biblioteca.repository;

import com.example.biblioteca.model.Book;
import com.example.biblioteca.model.Lend;
import com.example.biblioteca.model.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}
