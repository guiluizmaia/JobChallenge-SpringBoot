package com.siscred.JobChallenge.modules.schedule.application.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import com.siscred.JobChallenge.modules.schedule.domain.entity.VoteSchedule;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VoteScheduleDTOTest {
    @Test
    void createVoteScheduleByVoteScheduleDTO() {
        VoteScheduleDTO voteScheduleDTO = new VoteScheduleDTO(
            UUID.randomUUID(),
            UUID.randomUUID(),
            "y"
        );

        assertNotNull(voteScheduleDTO);

        UUID newUserId = UUID.randomUUID();
        voteScheduleDTO.setUserId(newUserId);
        assertEquals(voteScheduleDTO.getUserId(), newUserId);

        UUID newUScheduleId = UUID.randomUUID();
        voteScheduleDTO.setScheduleId(newUScheduleId);
        assertEquals(voteScheduleDTO.getScheduleId(), newUScheduleId);

        voteScheduleDTO.setResponse("n");
        assertEquals(voteScheduleDTO.getResponse(), "n");

        assertEquals(VoteSchedule.class, voteScheduleDTO.toEntity().getClass());
    }
}
