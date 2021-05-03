package com.rpiqueras.taskmanager.usermanager.repository.model;

import com.rpiqueras.taskmanager.usermanager.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "task_manager_users")
public class User implements Serializable {

    private static final long serialVersionUID = 7238755390752465062L;

    @Id
    private String id;

    @Field("user_id")
    @Indexed(unique=true)
    private String userId;

    @Field("name")
    private String name;

    @Field("surname")
    private String surname;

    @Field("email")
    private String email;

    @Field("user_role")
    private UserRole role;

}
