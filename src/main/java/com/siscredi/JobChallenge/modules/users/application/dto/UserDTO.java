package com.siscredi.JobChallenge.modules.users.application.dto;

import java.io.Serializable;

import com.siscredi.JobChallenge.modules.users.domain.entity.User;


public class UserDTO implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;


    public UserDTO(String firstName, String lastName, String email, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
    }


    public User toEntity(){
        User entity = new User(this.firstName, this.lastName, this.email, this.cpf);

        return entity;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    } 
}
