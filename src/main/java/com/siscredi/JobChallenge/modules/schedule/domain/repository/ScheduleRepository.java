package com.siscredi.JobChallenge.modules.schedule.domain.repository;
import java.util.UUID;

import com.siscredi.JobChallenge.modules.schedule.domain.entity.Schedule;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, UUID> {
    
}
