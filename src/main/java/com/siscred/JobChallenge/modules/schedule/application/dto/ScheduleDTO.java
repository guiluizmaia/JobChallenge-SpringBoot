package com.siscred.JobChallenge.modules.schedule.application.dto;

import java.io.Serializable;

import com.siscred.JobChallenge.modules.schedule.domain.entity.Schedule;


public class ScheduleDTO implements Serializable{
    private String schedule;
    private String timeMin;

    public ScheduleDTO(String schedule, String timeMin) {
        this.schedule = schedule;
        this.timeMin = timeMin;
    }

    public Schedule toEntity(){
        if(this.timeMin == null){
            this.timeMin = "1";
        }

        Schedule entity = new Schedule(this.schedule, this.timeMin);

        return entity;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTimeMin() {
        return this.timeMin;
    }

    public void setTimeMin(String timeMin) {
        this.timeMin = timeMin;
    }

}
