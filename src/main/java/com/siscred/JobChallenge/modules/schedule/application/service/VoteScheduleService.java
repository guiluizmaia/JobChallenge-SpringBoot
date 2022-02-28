package com.siscred.JobChallenge.modules.schedule.application.service;

import com.siscred.JobChallenge.exception.BadRequestException;
import com.siscred.JobChallenge.exception.ResourceNotFoundException;
import com.siscred.JobChallenge.modules.schedule.application.dto.VoteScheduleDTO;
import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;
import com.siscred.JobChallenge.modules.schedule.domain.entity.VoteSchedule;
import com.siscred.JobChallenge.modules.schedule.domain.repository.ScheduleRepository;
import com.siscred.JobChallenge.modules.schedule.domain.repository.VoteScheduleRepository;
import com.siscred.JobChallenge.modules.users.domain.entity.User;
import com.siscred.JobChallenge.modules.users.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service()
public class VoteScheduleService implements IVoteScheduleService {

    private VoteScheduleRepository voteScheduleRepository;
    private ScheduleRepository scheduleRepository;
    private UserRepository userRepository;

    public VoteScheduleService (
        VoteScheduleRepository voteScheduleRepository,
        ScheduleRepository scheduleRepository,
        UserRepository userRepository
    ){
        this.voteScheduleRepository = voteScheduleRepository;
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public VoteSchedule create(VoteScheduleDTO create) {
        Optional<User> user = this.userRepository.findById(create.getUserId());

        if (user.isPresent() == false){
            throw new ResourceNotFoundException("User", "ID", create.getUserId());
        }

        Schedule schedule = this.scheduleRepository.findById(create.getScheduleId()).orElseThrow(() -> {
            throw new ResourceNotFoundException("Schedule", "ID", create.getScheduleId());
        });
        
        if (schedule.getActive() == false){
            throw new BadRequestException("Schedule is no longer active");
        } 

        if(!create.getResponse().equals("y") && !create.getResponse().equals("n")){
            throw new BadRequestException("Response must be y or n");
        }

        List<VoteSchedule> votes = this.voteScheduleRepository.findByUserIdAndScheduleId(create.getUserId(), create.getScheduleId());

       

        if(votes.isEmpty() != true){
            throw new BadRequestException("User already voted");
        }

        return this.voteScheduleRepository.insert(create.toEntity());
    }
    
}
