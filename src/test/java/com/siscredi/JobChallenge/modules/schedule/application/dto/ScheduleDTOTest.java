package com.siscredi.JobChallenge.modules.schedule.application.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.siscredi.JobChallenge.modules.schedule.domain.entity.Schedule;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScheduleDTOTest {
    @Test
    void createScheduleByScheduleDTO() {
        ScheduleDTO scheduleDTO = new ScheduleDTO(
            "Vou passar no processo?",
            "10"
        );

        assertNotNull(scheduleDTO);

        scheduleDTO.setSchedule("Não vou passar no processo?");
        assertEquals(scheduleDTO.getSchedule(), "Não vou passar no processo?");

        scheduleDTO.setTimeMin("2");
        assertEquals(scheduleDTO.getTimeMin(), "2");

        assertEquals(Schedule.class, scheduleDTO.toEntity().getClass());
    }
}
