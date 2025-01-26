package com.amazingcode.in.example.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {
    private String recipient;
    private String subject;
    private String msgBody;
}