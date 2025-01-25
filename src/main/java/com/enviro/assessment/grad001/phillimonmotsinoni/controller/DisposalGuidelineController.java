package com.enviro.assessment.grad001.phillimonmotsinoni.controller;

import com.enviro.assessment.grad001.phillimonmotsinoni.model.DisposalGuideline;
import com.enviro.assessment.grad001.phillimonmotsinoni.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;
import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")  // Base URL for all disposal guideline-related endpoints
public class DisposalGuidelineController {
    @Autowired
    private DisposalGuidelineService service;  // Autowiring the DisposalGuidelineService to handle business logic

    // Get all DisposalGuidelines
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines() {
        return ResponseEntity.ok(service.getAllGuidelines());  // Return list of all guidelines
    }

    // Get a single DisposalGuideline by ID
    @GetMapping("read/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getGuidelineById(id));  // Return guideline by ID
    }

    // Create a new DisposalGuideline
    @PostMapping(value = "create", produces = "application/json")
    public ResponseEntity<String> createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        return ResponseEntity.ok(service.createGuideline(guideline));  // Save and return the created guideline
    }

    // Update an existing DisposalGuideline
    @PutMapping(value = "update/{id}", produces = "application/json")
    public ResponseEntity<String> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline updatedGuideline) {
        updatedGuideline.setId(id);  // Ensure we update the correct guideline by ID
        return ResponseEntity.ok(service.updateGuideline(id, updatedGuideline));  // Update and return the updated guideline
    }

    // Delete a DisposalGuideline by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id); // This will throw an exception if not found
        String message = "DisposalGuideline with id " + id + " has been deleted successfully!";  // Success message
        return ResponseEntity.ok(message);  // Return success message upon deletion
    }
}
