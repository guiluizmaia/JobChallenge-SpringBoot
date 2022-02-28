package com.siscred.JobChallenge.modules.schedule.application.service;

import java.util.List;

import com.siscred.JobChallenge.modules.schedule.application.dto.VoteScheduleDTO;
import com.siscred.JobChallenge.modules.schedule.domain.entity.VoteSchedule;

public interface IVoteScheduleService {
    VoteSchedule create(VoteScheduleDTO create);
}
