package com.siscred.JobChallenge.modules.users.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {
    
	@Test
	void createANewUser() {
        User userTest = new User(
            "firstNameTest", 
            "lastNameTest", 
            "gui@test.com", 
            "12345678910"
        );
        assertNotNull(userTest);
        assertNotNull(userTest.getId());
        
        userTest.setCpf("1234567891");
        assertEquals(userTest.getCpf(), "1234567891");        

        userTest.setEmail("test@test.com");
        assertEquals(userTest.getEmail(), "test@test.com");

        userTest.setFirstName("firstName");
        assertEquals(userTest.getFirstName(), "firstName");

        userTest.setLastName("lastName");
        assertEquals(userTest.getLastName(), "lastName");
	}

}
