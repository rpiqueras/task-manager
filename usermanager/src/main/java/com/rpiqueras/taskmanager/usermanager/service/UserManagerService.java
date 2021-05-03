package com.rpiqueras.taskmanager.usermanager.service;

import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;

import java.util.List;

public interface UserManagerService {

    List<UserDTO> getUsers();

    UserDTO getUserByUserId(String userId);

    UserDTO addUser(UserDTO userDTO);

    UserDTO deleteUserByUserId(String userId);

}
