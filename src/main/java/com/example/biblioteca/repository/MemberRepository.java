package com.example.biblioteca.repository;

import com.example.biblioteca.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
