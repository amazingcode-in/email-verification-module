package com.amazingcode.in.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amazingcode.in.example.entity.EmailVerificationData;

public interface EmailVerificationRepository extends JpaRepository<EmailVerificationData, Long> {
    EmailVerificationData findByEmail(String email);
}