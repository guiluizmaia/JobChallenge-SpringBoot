package com.siscred.JobChallenge.modules.users.domain.entity;

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
            "emailTest", 
            "12345678910"
        );
        
        assertNotNull(userTest);
        assertNotNull(userTest.getId());
	}

}
