package com.example.userservice.model;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String firstName;
    private String secondName;
    private String phone;
    private String email;

}
