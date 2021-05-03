package com.rpiqueras.taskmanager.usermanager.service.transformer.mapper;

import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import com.rpiqueras.taskmanager.usermanager.repository.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);

    List<UserDTO> usersToUserDTOs(List<User> users);

}


