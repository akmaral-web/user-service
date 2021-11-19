package com.example.userservice.service;

import com.example.userservice.model.Feedback;
import com.example.userservice.model.UserData;

import java.util.List;

public interface UserFeedbackService {
    List<Feedback> getUserFeedbacks(Long userId);
}
