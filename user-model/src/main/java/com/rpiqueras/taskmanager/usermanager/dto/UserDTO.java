package com.rpiqueras.taskmanager.usermanager.dto;

import com.rpiqueras.taskmanager.usermanager.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6628346085509076983L;

    private String userId;

    private String name;

    private String surname;

    private String email;

    private UserRole role;

}
