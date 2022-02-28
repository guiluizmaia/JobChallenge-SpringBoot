package com.siscred.JobChallenge.modules.schedule.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.siscred.JobChallenge.modules.schedule.application.dto.ScheduleDTO;
import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;
import com.siscred.JobChallenge.modules.schedule.domain.repository.ScheduleRepository;

import org.springframework.stereotype.Service;

@Service()
public class ScheduleService implements IScheduleService{

    private ScheduleRepository scheduleRepository;

    public ScheduleService (ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
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
        return this.scheduleRepository.insert(create.toEntity());
    }

    @Override
    public void setResult(Schedule schedule) {
        // TODO Auto-generated method stub
        
    }    
}
