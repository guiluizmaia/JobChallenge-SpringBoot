package com.siscredi.JobChallenge.modules.users.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.siscredi.JobChallenge.modules.users.application.dto.UserDTO;
import com.siscredi.JobChallenge.modules.users.domain.entity.User;

public interface UserServiceInterface {
    List<User> findAll();
    Optional<User> findById(UUID id);
    User create(UserDTO create);
}
