package com.example.userservice.service.impl;

import com.example.userservice.model.User;
import com.example.userservice.model.UserInfo;
import com.example.userservice.service.UserInformationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    private  RestTemplate restTemplate;

    @Override
    public List<User> getUserInfos(Long userId) {
        UserInfo userInfo = restTemplate.getForObject("http://localhost:8092/user/info/"+userId, UserInfo.class);
        return userInfo.getUsers();

        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        return restTemplate.exchange("http://book-info-service/book/info/" + userId,
                HttpMethod.GET, entity, User.class).getBody();


    }
}
