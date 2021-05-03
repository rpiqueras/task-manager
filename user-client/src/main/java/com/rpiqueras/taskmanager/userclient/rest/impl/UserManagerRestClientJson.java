package com.rpiqueras.taskmanager.userclient.rest.impl;

import com.rpiqueras.taskmanager.userclient.rest.UserManagerRestClient;
import com.rpiqueras.taskmanager.usermanager.constants.UrlConstants;
import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserManagerRestClientJson implements UserManagerRestClient {

    @Value("${usermanager.url.base-path}")
    private static String basePath;

    private final RestTemplate restTemplate;

    @Override
    public List<UserDTO> getUsers() {
        String uri = basePath + UrlConstants.BASE_URL + UrlConstants.GET_USERS_URL;

        return restTemplate.getForObject(uri, ArrayList.class);
    }

    @Override
    public UserDTO getUserById(String userId) {
        String uri = basePath + UrlConstants.BASE_URL + UrlConstants.GET_USER_BY_ID_URL;

        Map<String, String> params = new HashMap<>();
        params.put("userId", userId);

        return restTemplate.getForObject(uri, UserDTO.class, params);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        String uri = basePath + UrlConstants.BASE_URL + UrlConstants.ADD_USER_URL;

        return restTemplate.postForObject(uri, userDTO, UserDTO.class);
    }

    @Override
    public UserDTO deleteUserById(String userId) {
        String uri = basePath + UrlConstants.BASE_URL + UrlConstants.DELETE_USER_BY_ID_URL;

        Map<String, String> params = new HashMap<>();
        params.put("userId", userId);

        return restTemplate.exchange(uri, HttpMethod.DELETE, null, UserDTO.class, params).getBody();
//        return restTemplate.exchange(uri, HttpMethod.DELETE, new HttpEntity(new HttpHeaders()), UserDTO.class, params).getBody();
    }

}
