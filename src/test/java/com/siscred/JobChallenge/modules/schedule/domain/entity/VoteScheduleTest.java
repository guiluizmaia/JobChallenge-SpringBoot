package com.siscred.JobChallenge.modules.schedule.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VoteScheduleTest {
    @Test
    void createANewVoteSchedule() {
        UUID userId = UUID.randomUUID();
        UUID scheduleId = UUID.randomUUID();
        
        VoteSchedule voteSchedule = new VoteSchedule(
            userId, 
            scheduleId, 
            "s"
        );

        assertNotNull(voteSchedule);
        assertEquals(voteSchedule.getUserId(), userId);
        assertEquals(voteSchedule.getScheduleId(), scheduleId);

    }
}
