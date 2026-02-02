package com.example.stms_multi_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stms_multi_user.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User>findByEmail(String email);
    boolean existsByEmail(String email);
} 