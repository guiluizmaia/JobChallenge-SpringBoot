package com.siscredi.JobChallenge.modules.schedule.application.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.siscredi.JobChallenge.modules.schedule.application.dto.ScheduleDTO;
import com.siscredi.JobChallenge.modules.schedule.domain.entity.Schedule;

public interface ScheduleServiceInterface {
    List<Schedule> findAll();
    Optional<Schedule> findById(UUID id);
    Schedule create(ScheduleDTO create);
    void setResult(Schedule schedule);
}
