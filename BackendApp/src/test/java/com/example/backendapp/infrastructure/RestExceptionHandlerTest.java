package com.example.backendapp.infrastructure;

import jakarta.xml.bind.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestExceptionHandlerTest {

    private RestExceptionHandler restExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        restExceptionHandler = new RestExceptionHandler();
    }

    @Test
    public void testHandleAllExceptions() {
        Exception exception = new Exception();

        ResponseEntity<Object> response = restExceptionHandler.handleAllExceptions(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal server error", response.getBody());
    }

    @Test
    public void testHandleValidationExceptions() {
        ValidationException exception = new ValidationException("");

        ResponseEntity<Object> response = restExceptionHandler.handleValidationExceptions(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Validation error", response.getBody());
    }

    @Test
    public void testHandleNotFoundExceptions() {
        NoSuchElementException exception = new NoSuchElementException();

        ResponseEntity<Object> response = restExceptionHandler.handleNotFoundExceptions(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Entity not found", response.getBody());
    }

    @Test
    public void testHandleIlligalStateExceptions() {
        IllegalStateException exception = new IllegalStateException();

        ResponseEntity<Object> response = restExceptionHandler.handleIlligalStateExceptions(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Business logic validation", response.getBody());
    }
}
