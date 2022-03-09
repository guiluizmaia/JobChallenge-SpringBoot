package com.siscredi.JobChallenge.modules.schedule.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScheduleTests {
    @Test
    void createANewSchedule() {
        Schedule scheduleTest1 = new Schedule(
            "Vou conseguir a vaga?",
            "10",
            "s"
        );
        assertNotNull(scheduleTest1);
        assertNotNull(scheduleTest1.getId());
        
        scheduleTest1.setActiveToFalse();
        assertEquals(scheduleTest1.getActive(), false);

        scheduleTest1.setResult("n");
        assertEquals(scheduleTest1.getResult(), "n");
        
        scheduleTest1.setSchedule("Teste?");
        assertEquals(scheduleTest1.getSchedule(), "Teste?");
        
        Schedule scheduleTest2 = new Schedule(
            "Vou conseguir a vaga?",
            "10"
        );
        assertNotNull(scheduleTest2);
        assertNotNull(scheduleTest2.getId());


        Schedule scheduleTest3 = new Schedule();
        assertNotNull(scheduleTest3);
        assertNotNull(scheduleTest3.getId());


    }
}
