package com.amazingcode.in.example.service.impl;

import org.springframework.stereotype.Service;

import com.amazingcode.in.example.entity.EmailVerificationData;
import com.amazingcode.in.example.repository.EmailVerificationRepository;
import com.amazingcode.in.example.request.EmailVerificationRequest;
import com.amazingcode.in.example.response.EmailDetails;
import com.amazingcode.in.example.response.EmailVerificationResponse;
import com.amazingcode.in.example.service.EmailService;
import com.amazingcode.in.example.service.EmailVerificationService;
import com.amazingcode.in.example.service.OtpGeneratorService;

@Service
public class EmailVerificationServiceImpl implements EmailVerificationService {

    private final EmailVerificationRepository repository;
    private final EmailService emailService;
    private final OtpGeneratorService otpGenerator;

    public EmailVerificationServiceImpl(EmailVerificationRepository repository, EmailService emailService, OtpGeneratorService otpGenerator) {
        this.repository = repository;
        this.emailService = emailService;
        this.otpGenerator = otpGenerator;
    }

    @Override
    public EmailVerificationResponse generateOtp(EmailVerificationRequest request) {
        String otp = otpGenerator.getRandomOtp();

        EmailVerificationData data = repository.findByEmail(request.getEmail());
        if (data == null) {
            data = new EmailVerificationData(null, request.getEmail(), otp, false);
        } else {
            data.setOtp(otp);
        }
        repository.save(data);

        EmailDetails emailDetails = new EmailDetails(data.getEmail(), "OTP Verification", "Your OTP is: " + otp + " to verify email.");
        emailService.sendEmail(emailDetails);

        return new EmailVerificationResponse(data.getEmail(), data.isValid());
    }

    @Override
    public EmailVerificationResponse verifyEmail(String otp, EmailVerificationRequest request) {
        EmailVerificationData data = repository.findByEmail(request.getEmail());
        if (data == null || !otp.equals(data.getOtp())) {
            return new EmailVerificationResponse(request.getEmail(), false);
        }

        data.setValid(true);
        repository.save(data);

        return new EmailVerificationResponse(data.getEmail(), true);
    }
}