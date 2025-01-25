package com.enviro.assessment.grad001.phillimonmotsinoni.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// This class globally handles exceptions in your application.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles validation exceptions when input data is not valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        // Iterate through all field errors and collect error messages.
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        // Returning a JSON response with status BAD_REQUEST
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // Handles custom ResourceNotFoundException (e.g., when a resource like a WasteCategory is not found)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        // Returning a custom error message with status NOT_FOUND (404)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
