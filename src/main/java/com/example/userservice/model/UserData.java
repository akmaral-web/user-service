package com.example.userservice.model;

import lombok.Data;

@Data
public class UserData {
    private Long userId;
    private String firstName;
    private String secondName;
    private String phone;
    private String email;
    private String feedback;
}
