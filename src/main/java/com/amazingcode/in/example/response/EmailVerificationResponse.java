package com.amazingcode.in.example.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerificationResponse {
    private String email;
    private boolean valid;
}