package com.example.backendapp.infrastructure;

import jakarta.xml.bind.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
    private static final Logger log = LogManager.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllExceptions(Exception e)
    {
        log.error("Exception: '{}' -> {}", e.getClass().getName(), e.getMessage());
        return buildResponeEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    }

    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<Object> handleValidationExceptions(ValidationException e)
    {
        log.error("Exception: '{}' -> {}", e.getClass().getName(), e.getMessage());
        return buildResponeEntity(HttpStatus.BAD_REQUEST, "Validation error");
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> handleNotFoundExceptions(NoSuchElementException e)
    {
        log.warn("Exception: '{}' -> {}", e.getClass().getName(), e.getMessage());
        return buildResponeEntity(HttpStatus.NOT_FOUND, "Entity not found");
    }

    @ExceptionHandler(IllegalStateException.class)
    protected ResponseEntity<Object> handleIlligalStateExceptions(IllegalStateException e)
    {
        log.warn("Exception: '{}' -> {}", e.getClass().getName(), e.getMessage());
        return buildResponeEntity(HttpStatus.BAD_REQUEST, "Business logic validation");
    }

    private ResponseEntity<Object> buildResponeEntity(HttpStatus httpStatus, String error)
    {
        return new ResponseEntity<>(error, new HttpHeaders(), httpStatus);
    }
}
