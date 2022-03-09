package com.siscredi.JobChallenge.modules.users.application.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.siscredi.JobChallenge.modules.users.domain.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDTOTest {
    
    @Test
    void createUserByUserDTO(){
        UserDTO userDTO = new UserDTO(
            "Guilherme", 
            "Maia", 
            "guilherme@teste.com",
            "454.369.897-85"
        );

        assertNotNull(userDTO);

        userDTO.setCpf("454.369.897-86");
        assertEquals(userDTO.getCpf(), "454.369.897-86");

        userDTO.setEmail("gui@teste.com");
        assertEquals(userDTO.getEmail(), "gui@teste.com");

        userDTO.setFirstName("Gabriel");
        assertEquals(userDTO.getFirstName(), "Gabriel");

        userDTO.setLastName("Silva");
        assertEquals(userDTO.getLastName(), "Silva");

        assertEquals(User.class, userDTO.toEntity().getClass());
    }
}
