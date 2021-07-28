package com.rpiqueras.taskmanager.usermanager.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationUser {

    private String user;
    private String password;
    private String token;
}
