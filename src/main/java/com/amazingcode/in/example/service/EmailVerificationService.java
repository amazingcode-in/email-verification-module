package com.amazingcode.in.example.service;

import com.amazingcode.in.example.request.EmailVerificationRequest;
import com.amazingcode.in.example.response.EmailVerificationResponse;

public interface EmailVerificationService {
    EmailVerificationResponse generateOtp(EmailVerificationRequest request);
    EmailVerificationResponse verifyEmail(String otp, EmailVerificationRequest request);
}