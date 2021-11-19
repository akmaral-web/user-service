package com.example.userservice.controller;


import com.example.userservice.model.User;
import com.example.userservice.model.UserData;
import com.example.userservice.service.UserInformationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@EnableHystrix
public class UserController {



    @Autowired
    private UserInformationService userInformationService;


    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserInfos(@PathVariable("userId") Long userId) {

        List<User> userInfo = userInformationService.getUserInfos(userId);


        List<UserData> userData = new ArrayList<>();
        for (User user : userInfo) {
            UserData userData1 = new UserData();

            userData1.setUserId(user.getUserId());
            userData1.setFirstName(user.getFirstName());
            userData1.setSecondName(user.getSecondName());
            userData1.setPhone(user.getPhone());
            userData1.setEmail(user.getEmail());

        }
        return ResponseEntity.ok(userData);
    }

    //Hystrix methods
    @RequestMapping(value = "/")
    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        return "Welcome Hystrix";
    }

    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }

}
