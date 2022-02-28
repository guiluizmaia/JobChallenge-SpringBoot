package com.siscred.JobChallenge.modules.schedule.application.dto;

import java.io.Serializable;

import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDTO implements Serializable{
    private String schedule;
    private String timeMin;

    public Schedule toEntity(){
        Schedule entity = new Schedule(this.schedule, this.timeMin);
        return entity;
    }
}
