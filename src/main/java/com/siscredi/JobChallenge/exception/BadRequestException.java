package com.siscredi.JobChallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
