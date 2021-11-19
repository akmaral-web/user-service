package com.example.userservice.model;

import lombok.Data;

@Data
public class Feedback {
    private Long userId;
    private String feedback;
}
