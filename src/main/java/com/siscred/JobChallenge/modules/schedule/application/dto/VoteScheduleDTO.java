package com.siscred.JobChallenge.modules.schedule.application.dto;

import java.io.Serializable;
import java.util.UUID;

import com.siscred.JobChallenge.modules.schedule.domain.entity.VoteSchedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteScheduleDTO implements Serializable {
    private UUID userId;
    private UUID scheduleId;
    private String response;

    public VoteSchedule toEntity(){
        VoteSchedule entity = new VoteSchedule(this.userId, this.scheduleId, this.response);
        return entity;
    }


    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(UUID scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
