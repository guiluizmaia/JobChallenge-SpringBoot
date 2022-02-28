package com.siscred.JobChallenge.modules.users.application.dto;

import java.io.Serializable;

import com.siscred.JobChallenge.modules.users.domain.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    
    
    public User toEntity(){
        User entity = new User(this.firstName, this.lastName, this.email, this.cpf);

        return entity;
    }
}
