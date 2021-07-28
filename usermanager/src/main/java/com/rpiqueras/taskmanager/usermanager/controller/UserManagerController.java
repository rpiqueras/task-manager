package com.rpiqueras.taskmanager.usermanager.controller;

import com.rpiqueras.taskmanager.usermanager.constants.UrlConstants;
import com.rpiqueras.taskmanager.usermanager.dto.UserDTO;
import com.rpiqueras.taskmanager.usermanager.service.UserManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlConstants.BASE_URL)
@Slf4j
@RequiredArgsConstructor
public class UserManagerController {

    private final UserManagerService userManagerService;

    @GetMapping(value = UrlConstants.PRUEBA_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> prueba() {
        log.info("Call to prueba controller started");
        log.info("Call to prueba controller finished");
        return ResponseEntity.ok("Funciona");
    }

    @GetMapping(value = UrlConstants.GET_USERS_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getUsers() {
        log.info("Call to getUsers controller started");

        List<UserDTO> response = userManagerService.getUsers();

        log.info("Call to getUsers controller finished");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = UrlConstants.GET_USER_BY_ID_URL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserByUserId(@PathVariable("userId") String userId) {
        log.info("Call to getUser controller {} started", userId);

        UserDTO response = userManagerService.getUserByUserId(userId);

        log.info("Call to getUser controller {} finished", userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping(UrlConstants.ADD_USER_URL)
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        log.info("Call to addUser controller started");

        UserDTO response = userManagerService.addUser(userDTO);

        log.info("Call to addUser controller finished");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(UrlConstants.DELETE_USER_BY_ID_URL)
    public ResponseEntity<UserDTO> deleteUserByUserId(@PathVariable("userId") String userId) {
        log.info("Call to deleteUser controller {} started", userId);

        UserDTO response = userManagerService.deleteUserByUserId(userId);

        log.info("Call to deleteUser controller {} finished", userId);
        return ResponseEntity.ok(response);
    }

}
