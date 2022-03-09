package com.siscredi.JobChallenge.modules.schedule.application.web;

import java.util.List;
import java.util.UUID;

import com.siscredi.JobChallenge.exception.BadRequestException;
import com.siscredi.JobChallenge.exception.ResourceNotFoundException;
import com.siscredi.JobChallenge.modules.schedule.application.dto.ScheduleDTO;
import com.siscredi.JobChallenge.modules.schedule.application.dto.VoteScheduleDTO;
import com.siscredi.JobChallenge.modules.schedule.application.service.IScheduleService;
import com.siscredi.JobChallenge.modules.schedule.application.service.IVoteScheduleService;
import com.siscredi.JobChallenge.modules.schedule.domain.entity.Schedule;
import com.siscredi.JobChallenge.modules.schedule.domain.entity.VoteSchedule;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private IScheduleService scheduleService;
    private IVoteScheduleService voteScheduleService;


    public ScheduleController(
        IScheduleService scheduleService,
        IVoteScheduleService voteScheduleService
    ){
        this.scheduleService = scheduleService;
        this.voteScheduleService = voteScheduleService;
    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody ScheduleDTO toAdd){
        try {
            Schedule schedule = this.scheduleService.create(toAdd);
            return ResponseEntity.status(HttpStatus.CREATED).body(schedule);
        } catch (Exception e) {
            throw new BadRequestException("Error creating a schedule");
        }
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Schedule> schedule = this.scheduleService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Schedule schedule = this.scheduleService.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Schedule", "ID", id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }


    @PostMapping("/{id}/vote")
    public ResponseEntity createVoteSchedule(@Validated @PathVariable(value = "id") UUID id, @RequestBody VoteScheduleDTO toAdd){
            toAdd.setScheduleId(id);
            VoteSchedule schedule = this.voteScheduleService.create(toAdd);
            return ResponseEntity.status(HttpStatus.CREATED).body(schedule);
    }
}
