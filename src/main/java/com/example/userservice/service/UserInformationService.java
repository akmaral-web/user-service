package com.example.userservice.service;

import com.example.userservice.model.User;

import java.util.List;

public interface UserInformationService {
    List<User> getUserInfos(Long userId);
}
