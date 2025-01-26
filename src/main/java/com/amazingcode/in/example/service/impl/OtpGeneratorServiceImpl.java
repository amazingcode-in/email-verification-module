package com.amazingcode.in.example.service.impl;

import java.security.SecureRandom;
import org.springframework.stereotype.Service;
import com.amazingcode.in.example.service.OtpGeneratorService;

@Service
public class OtpGeneratorServiceImpl implements OtpGeneratorService {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int OTP_BOUND = 900000;
    private static final int OTP_OFFSET = 100000;

    @Override
    public String getRandomOtp() {
        return String.valueOf(OTP_OFFSET + RANDOM.nextInt(OTP_BOUND));
    }
}