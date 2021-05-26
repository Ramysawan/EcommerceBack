package com.Monty.Ecommerce.ResourceNotFoundException;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ResourceException {

    private final String message;
    private final String httpStatus;
    private final ZonedDateTime timeStamp;

    public ResourceException(String message, String httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

}
