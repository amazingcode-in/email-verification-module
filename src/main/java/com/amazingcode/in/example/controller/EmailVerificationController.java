package com.amazingcode.in.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amazingcode.in.example.request.EmailVerificationRequest;
import com.amazingcode.in.example.response.EmailVerificationResponse;
import com.amazingcode.in.example.service.EmailVerificationService;

@RestController
@RequestMapping("/api/email")
public class EmailVerificationController {

    private final EmailVerificationService emailVerificationService;

    public EmailVerificationController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/generate-token")
    public ResponseEntity<EmailVerificationResponse> generateOtp(@RequestBody EmailVerificationRequest request) {
        return ResponseEntity.ok(emailVerificationService.generateOtp(request));
    }

    @PostMapping("/verify-email")
    public ResponseEntity<EmailVerificationResponse> verifyEmail(@RequestParam String otp, @RequestParam String email) {
        EmailVerificationRequest request = new EmailVerificationRequest(email);
        return ResponseEntity.ok(emailVerificationService.verifyEmail(otp, request));
    }
}