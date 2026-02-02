package com.example.stms_multi_user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stms_multi_user.entities.EmailOtp;

public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long> {
    Optional<EmailOtp> findByEmail(String email);
    void deleteByEmail(String email);
}
