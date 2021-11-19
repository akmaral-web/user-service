package com.example.userservice.service.impl;

import com.example.userservice.model.Feedback;
import com.example.userservice.model.UserFeedback;
import com.example.userservice.service.UserFeedbackService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {

    @Autowired
    private RestTemplate restTemplate;


    @Override

    public List<Feedback> getUserFeedbacks(Long userId) {

        UserFeedback userFeedback = restTemplate.getForObject(
                "http://localhost:8093/user/feedback"+userId, UserFeedback.class);

        return getUserFeedbacks(userId);



    }


}
