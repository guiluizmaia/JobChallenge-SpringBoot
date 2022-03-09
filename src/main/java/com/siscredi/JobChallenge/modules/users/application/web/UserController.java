package com.siscredi.JobChallenge.modules.users.application.web;

import java.util.List;
import java.util.UUID;

import com.siscredi.JobChallenge.exception.BadRequestException;
import com.siscredi.JobChallenge.exception.ResourceNotFoundException;
import com.siscredi.JobChallenge.modules.users.application.dto.UserDTO;
import com.siscredi.JobChallenge.modules.users.application.service.IUserService;
import com.siscredi.JobChallenge.modules.users.domain.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    
    private IUserService userService;

    
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody UserDTO toAdd) {
        try {
            User user  = this.userService.create(toAdd);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);   
        } catch(Exception e) {
            throw new BadRequestException("Error creating a User");
        }     
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<User> users  = this.userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);        
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id) {
        User user  = this.userService.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "ID", id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(user);        
    }
}
