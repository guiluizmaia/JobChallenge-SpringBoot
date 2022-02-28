package com.siscred.JobChallenge.modules.schedule.application.service;

import com.siscred.JobChallenge.modules.schedule.application.dto.VoteScheduleDTO;
import com.siscred.JobChallenge.modules.schedule.domain.entity.VoteSchedule;
import com.siscred.JobChallenge.modules.schedule.domain.repository.ScheduleRepository;
import com.siscred.JobChallenge.modules.schedule.domain.repository.VoteScheduleRepository;

import org.springframework.stereotype.Service;

@Service()
public class VoteScheduleService implements IVoteScheduleService {

    private VoteScheduleRepository voteScheduleRepository;
    private ScheduleRepository scheduleRepository;

    public VoteScheduleService (
        VoteScheduleRepository voteScheduleRepository,
        ScheduleRepository scheduleRepository
    ){
        this.voteScheduleRepository = voteScheduleRepository;
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public VoteSchedule create(VoteScheduleDTO create) {
        this.scheduleRepository.findById(create.getScheduleId());
        return null;
    }
    
}
