package com.rpiqueras.taskmanager.usermanager.service.transformer.impl;

import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import com.rpiqueras.taskmanager.usermanager.repository.model.User;
import com.rpiqueras.taskmanager.usermanager.service.transformer.UserTransformer;
import com.rpiqueras.taskmanager.usermanager.service.transformer.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTransformerImpl implements UserTransformer {

    private final UserMapper userMapper;

    public User userDTOToUser(UserDTO userDTO){
        return userMapper.userDTOToUser(userDTO);
    }

    public UserDTO userToUserDTO(User user){
        return userMapper.userToUserDTO(user);
    }

    public List<UserDTO> usersToUserDTOs(List<User> users){
        return userMapper.usersToUserDTOs(users);
    }

}
