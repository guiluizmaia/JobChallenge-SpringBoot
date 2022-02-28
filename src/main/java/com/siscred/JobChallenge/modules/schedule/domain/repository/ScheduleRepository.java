package com.siscred.JobChallenge.modules.schedule.domain.repository;
import java.util.List;
import java.util.UUID;

import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ScheduleRepository extends MongoRepository<Schedule, UUID> {
    
}
