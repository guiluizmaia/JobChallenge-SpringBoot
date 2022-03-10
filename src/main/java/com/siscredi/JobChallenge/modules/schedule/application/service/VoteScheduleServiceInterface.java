package com.siscredi.JobChallenge.modules.schedule.application.service;


import com.siscredi.JobChallenge.modules.schedule.application.dto.VoteScheduleDTO;
import com.siscredi.JobChallenge.modules.schedule.domain.entity.VoteSchedule;

public interface VoteScheduleServiceInterface {
    VoteSchedule create(VoteScheduleDTO create);
}
