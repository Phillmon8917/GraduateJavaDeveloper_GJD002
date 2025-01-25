package com.enviro.assessment.grad001.phillimonmotsinoni.exception;

// Custom exception for when a resource is not found.
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);  // Passing the message to the superclass (RuntimeException)
    }
}

