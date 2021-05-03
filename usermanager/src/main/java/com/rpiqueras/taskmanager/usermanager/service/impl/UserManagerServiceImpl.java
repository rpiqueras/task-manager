package com.rpiqueras.taskmanager.usermanager.service.impl;

import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import com.rpiqueras.taskmanager.usermanager.repository.UserManagerRepository;
import com.rpiqueras.taskmanager.usermanager.repository.model.User;
import com.rpiqueras.taskmanager.usermanager.service.UserManagerService;
import com.rpiqueras.taskmanager.usermanager.service.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserManagerServiceImpl implements UserManagerService {

    private final UserManagerRepository userManagerRepository;
    private final UserTransformer userTransformer;

    @Override
    public List<UserDTO> getUsers() {
        log.info("Call to getUsers service started");

        List<User> users = userManagerRepository.findAll();
        List<UserDTO> userDTOs = userTransformer.usersToUserDTOs(users);

        log.info("Call to getUsers service finished");
        return userDTOs;
    }

    @Override
    public UserDTO getUserByUserId(String userId) {
        log.info("Call to getUser service {} started", userId);

        Optional<User> user = userManagerRepository.findByUserId(userId);
        UserDTO userDTO = userTransformer.userToUserDTO(user.orElse(null));

        log.info("Call to getUser service {} finished", userId);
        return userDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        log.info("Call to addUser service started");

        User user = userTransformer.userDTOToUser(userDTO);

        try {
            userManagerRepository.save(user);
        } catch (DuplicateKeyException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate key: userId already exist", e);
        }



        userDTO = userTransformer.userToUserDTO(user);

        log.info("Call to addUser service finished");
        return userDTO;
    }

    @Override
    public UserDTO deleteUserByUserId(String userId) {
        log.info("Call to deleteUser service {} started", userId);

        Optional<User> user = userManagerRepository.findByUserId(userId);
        if(user.isPresent()) userManagerRepository.delete(user.get());
        UserDTO userDTO = userTransformer.userToUserDTO(user.orElse(null));

        log.info("Call to deleteUser service {} finished", userId);
        return userDTO;
    }

}