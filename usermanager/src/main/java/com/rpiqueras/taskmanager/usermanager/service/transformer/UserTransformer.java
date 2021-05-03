package com.rpiqueras.taskmanager.usermanager.service.transformer;

import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import com.rpiqueras.taskmanager.usermanager.repository.model.User;

import java.util.List;

public interface UserTransformer {

    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);

    List<UserDTO> usersToUserDTOs(List<User> users);

}
