package com.amazingcode.in.example.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerificationRequest {
    private String email;
}