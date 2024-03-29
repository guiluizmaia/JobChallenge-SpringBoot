package com.siscredi.JobChallenge.modules.users.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.siscredi.JobChallenge.modules.users.application.dto.UserDTO;
import com.siscredi.JobChallenge.modules.users.domain.entity.User;
import com.siscredi.JobChallenge.modules.users.domain.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserDTO dto) {
       return this.userRepository.insert(dto.toEntity());
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return this.userRepository.findById(id);
    }
}
