package com.rpiqueras.taskmanager.userclient.rest.impl;

import com.rpiqueras.taskmanager.usermanager.constants.UrlConstants;
import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UserManagerRestClientJsonTest {

    private final static String BASE_PATH = "http://localhost:8081";
    private final static String BASE_PATH_FIELD = "basePath";

    @InjectMocks
    private UserManagerRestClientJson userManagerRestClientJson;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(userManagerRestClientJson, BASE_PATH_FIELD, BASE_PATH);
    }

    @Test
    public void getUsers() {
        String uri = BASE_PATH + UrlConstants.BASE_URL + UrlConstants.GET_USERS_URL;

        when(restTemplate.getForObject(uri, ArrayList.class)).thenReturn(buildUserDTOs());

        List<UserDTO> result = userManagerRestClientJson.getUsers();

        assertThat(result).isNotEmpty();
        assertThat(result).doesNotContainNull();
    }

    private ArrayList<UserDTO> buildUserDTOs() {
        ArrayList<UserDTO> userDTOs = new ArrayList<>();
        userDTOs.add(new UserDTO());
        return userDTOs;
    }

}