package com.siscred.JobChallenge.modules.schedule.application.web;

import java.util.UUID;

import com.siscred.JobChallenge.exception.BadRequestException;
import com.siscred.JobChallenge.exception.ResourceNotFoundException;
import com.siscred.JobChallenge.modules.schedule.application.dto.ScheduleDTO;
import com.siscred.JobChallenge.modules.schedule.application.service.IScheduleService;
import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;

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

    public ScheduleController(IScheduleService scheduleService){
        this.scheduleService = scheduleService;
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

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Schedule schedule = this.scheduleService.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Schedule", "ID", id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }
}
