package com.superherogame.cleonildo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorInfo> entityNotFound(NotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorInfo err = new ErrorInfo(Instant.now(), status.value(), exception.getMessage());
        return ResponseEntity.status(status).body(err);
    }
}
