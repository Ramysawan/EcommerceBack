package com.Monty.Ecommerce.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import sun.security.provider.certpath.OCSPResponse;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceExceptionHandler(ResourceNotFoundException e, WebRequest webRequest){

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ResourceException resourceException = new ResourceException(e.getMessage(), webRequest.getDescription(false), ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(resourceException, badRequest);
    }
}
