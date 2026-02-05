package com.example.stms_multi_user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stms_multi_user.entities.TempUser;

public interface TempUserRepository extends JpaRepository<TempUser, String> {
    Optional<TempUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
