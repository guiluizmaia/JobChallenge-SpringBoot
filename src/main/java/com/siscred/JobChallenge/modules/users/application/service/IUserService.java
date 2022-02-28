package com.siscred.JobChallenge.modules.users.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.siscred.JobChallenge.modules.users.application.dto.UserDTO;
import com.siscred.JobChallenge.modules.users.domain.entity.User;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(UUID id);
    User create(UserDTO create);
}
