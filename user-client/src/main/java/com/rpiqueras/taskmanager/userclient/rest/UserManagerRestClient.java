package com.rpiqueras.taskmanager.userclient.rest;

import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;

import java.util.List;

public interface UserManagerRestClient {

    List<UserDTO> getUsers();

    UserDTO getUserById(final String userId);

    UserDTO addUser(final UserDTO userDTO);

    UserDTO deleteUserById(final String userId);

}
