package com.rpiqueras.taskmanager.usermanager.controller;

import com.rpiqueras.taskmanager.usermanager.constants.UrlConstants;
import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import com.rpiqueras.taskmanager.usermanager.service.UserManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserManagerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserManagerController userManagerController;

    @Mock
    private UserManagerService userManagerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userManagerController).build();
    }

    @Test
    public void getUsers() throws Exception {
        String urlPath = UrlConstants.BASE_URL + UrlConstants.GET_USERS_URL;

        when(userManagerService.getUsers()).thenReturn(buildUserDTOs());

        mockMvc.perform(MockMvcRequestBuilders.get(urlPath)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    private List<UserDTO> buildUserDTOs() {
        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs.add(new UserDTO());
        return userDTOs;
    }

}