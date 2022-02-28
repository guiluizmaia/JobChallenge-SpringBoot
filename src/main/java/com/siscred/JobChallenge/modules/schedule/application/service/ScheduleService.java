package com.siscred.JobChallenge.modules.schedule.application.service;

import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import com.siscred.JobChallenge.modules.schedule.application.dto.ScheduleDTO;
import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;
import com.siscred.JobChallenge.modules.schedule.domain.entity.VoteSchedule;
import com.siscred.JobChallenge.modules.schedule.domain.repository.ScheduleRepository;
import com.siscred.JobChallenge.modules.schedule.domain.repository.VoteScheduleRepository;

import org.springframework.stereotype.Service;

@Service()
public class ScheduleService implements IScheduleService{

    private ScheduleRepository scheduleRepository;
    private VoteScheduleRepository voteScheduleRepository;

    public ScheduleService (
        ScheduleRepository scheduleRepository, 
        VoteScheduleRepository voteScheduleRepository
    ){
        this.scheduleRepository = scheduleRepository;
        this.voteScheduleRepository = voteScheduleRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return this.scheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> findById(UUID id) {
        return this.scheduleRepository.findById(id);
    }

    @Override
    public Schedule create(ScheduleDTO create) {
        Schedule created = this.scheduleRepository.insert(create.toEntity());
        
        Integer timeExpiredInMin = Integer.parseInt(created.getTimeMin());

        Integer timeExpiredInMilli = timeExpiredInMin * 60000;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override public void run() { 
                setResult(created); 
            }   
        }, timeExpiredInMilli);
        return created;
    }

    @Override
    public void setResult(Schedule schedule) {
        List<VoteSchedule> votes = this.voteScheduleRepository.findByScheduleId(schedule.getId());
        if(votes.isEmpty()){
            schedule.setResult("no votes");
        } else {
            Integer y = 0;
            Integer n = 0;

            for(int i = 0; i < votes.size(); i++){
                VoteSchedule vote = votes.get(i);
                if(vote.getResponse().equals("y")){
                    y += 1;
                }else if (vote.getResponse().equals("n")){
                    n += 1;
                }
            }

            if(y > n){
                schedule.setResult("y");
            }else if(y < n){
                schedule.setResult("n");
            }
        }

        schedule.setActiveToFalse();
        this.scheduleRepository.save(schedule);
    }    
}
