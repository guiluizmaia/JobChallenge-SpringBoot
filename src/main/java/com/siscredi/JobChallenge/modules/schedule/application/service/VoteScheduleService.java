package com.siscredi.JobChallenge.modules.schedule.application.service;

import com.siscredi.JobChallenge.exception.BadRequestException;
import com.siscredi.JobChallenge.exception.ResourceNotFoundException;
import com.siscredi.JobChallenge.modules.schedule.application.dto.VoteScheduleDTO;
import com.siscredi.JobChallenge.modules.schedule.domain.entity.Schedule;
import com.siscredi.JobChallenge.modules.schedule.domain.entity.VoteSchedule;
import com.siscredi.JobChallenge.modules.schedule.domain.repository.ScheduleRepository;
import com.siscredi.JobChallenge.modules.schedule.domain.repository.VoteScheduleRepository;
import com.siscredi.JobChallenge.modules.users.domain.entity.User;
import com.siscredi.JobChallenge.modules.users.domain.repository.UserRepository;
import com.siscredi.JobChallenge.utils.IsValidCPF.IIsAbleVoteByCPF;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service()
public class VoteScheduleService implements VoteScheduleServiceInterface {

    private VoteScheduleRepository voteScheduleRepository;
    private ScheduleRepository scheduleRepository;
    private UserRepository userRepository;
    private IIsAbleVoteByCPF isAbleVoteByCPF;

    public VoteScheduleService (
        VoteScheduleRepository voteScheduleRepository,
        ScheduleRepository scheduleRepository,
        UserRepository userRepository,
        IIsAbleVoteByCPF isAbleVoteByCPF
    ){
        this.voteScheduleRepository = voteScheduleRepository;
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.isAbleVoteByCPF = isAbleVoteByCPF;
    }

    @Override
    public VoteSchedule create(VoteScheduleDTO create) {
        Optional<User> user = this.userRepository.findById(create.getUserId());

        if (user.isPresent() == false){
            throw new ResourceNotFoundException("User", "ID", create.getUserId());
        }

        Boolean isAble = this.isAbleVoteByCPF.isAbleVoteByCPF(user.get().getCpf());
        
        if(!isAble){
            throw new BadRequestException("User is not able to vote");
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
