package com.siscredi.JobChallenge.modules.schedule.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Schedule {
    @Id
    private UUID id;
    private String schedule;
    private String timeMin;
    private String result;
    private Boolean active = true;
    private LocalDateTime create;


    public Schedule(String schedule, String timeMin, String result) {
        this.id = UUID.randomUUID();
        this.schedule = schedule;
        this.timeMin = timeMin;
        this.result = result;
        this.create = LocalDateTime.now();
    }

    public Schedule(String schedule, String timeMin) {
        this.id = UUID.randomUUID();
        this.schedule = schedule;
        this.timeMin = timeMin;
        this.create = LocalDateTime.now();
    }


    public Schedule() {
        this.id = UUID.randomUUID();
    }
    

    public UUID getId() {
        return this.id;
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
    
    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getCreate() {
        return this.create;
    }
    
    public Boolean getActive() {
        return this.active;
    }

    public void setActiveToFalse() {
        this.active = false;
    }
}
