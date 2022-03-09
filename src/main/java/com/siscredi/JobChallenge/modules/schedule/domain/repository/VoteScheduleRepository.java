package com.siscredi.JobChallenge.modules.schedule.domain.repository;
import java.util.List;
import java.util.UUID;

import com.siscredi.JobChallenge.modules.schedule.domain.entity.VoteSchedule;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VoteScheduleRepository extends MongoRepository<VoteSchedule, UUID> {
    @Query("{'userId': ?0, 'scheduleId': ?1}")
    List<VoteSchedule> findByUserIdAndScheduleId(UUID userId, UUID scheduleId);
    @Query("{'scheduleId': ?0}")
    List<VoteSchedule> findByScheduleId(UUID scheduleId);
}
