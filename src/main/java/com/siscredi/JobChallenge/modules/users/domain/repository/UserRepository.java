package com.siscredi.JobChallenge.modules.users.domain.repository;

import com.siscredi.JobChallenge.modules.users.domain.entity.User;

import java.util.UUID;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, UUID> {
    
}
