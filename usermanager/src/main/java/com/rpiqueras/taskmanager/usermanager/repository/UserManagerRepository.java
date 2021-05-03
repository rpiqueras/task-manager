package com.rpiqueras.taskmanager.usermanager.repository;

import com.rpiqueras.taskmanager.usermanager.model.UserRole;
import com.rpiqueras.taskmanager.usermanager.repository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserManagerRepository extends MongoRepository<User, String> {

    Optional<User> findByUserId(String userId);

    List<User> findByRole(UserRole role);

}
