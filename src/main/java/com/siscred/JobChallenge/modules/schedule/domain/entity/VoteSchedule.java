package com.siscred.JobChallenge.modules.schedule.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VoteSchedule {
    @Id
    private UUID id;
    private UUID userId;
    private UUID scheduleId;
    private String response;
    private LocalDateTime voteTime;

    public VoteSchedule(UUID userId, UUID scheduleId, String response) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.response = response;
        this.voteTime = LocalDateTime.now();
    }
    
    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDateTime getCreate() {
        return this.voteTime;
    }
}
