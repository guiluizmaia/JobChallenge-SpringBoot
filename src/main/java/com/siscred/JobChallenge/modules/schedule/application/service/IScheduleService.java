package com.siscred.JobChallenge.modules.schedule.application.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.siscred.JobChallenge.modules.schedule.application.dto.ScheduleDTO;
import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;

public interface IScheduleService {
    List<Schedule> findAll();
    Optional<Schedule> findById(UUID id);
    Schedule create(ScheduleDTO create);
    void setResult(Schedule schedule);
}
