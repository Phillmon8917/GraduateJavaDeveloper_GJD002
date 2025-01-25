package com.enviro.assessment.grad001.phillimonmotsinoni.controller;

import com.enviro.assessment.grad001.phillimonmotsinoni.model.RecyclingTip;
import com.enviro.assessment.grad001.phillimonmotsinoni.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService service;

    // Get all RecyclingTips
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllTips() {
        return ResponseEntity.ok(service.getAllTips());  // Fetch and return all tips
    }

    // Get a single RecyclingTip by ID
    @GetMapping("read/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTipById(id));  // Fetch and return the tip by ID
    }

    // Create a new RecyclingTip
    @PostMapping(value = "create", produces = "application/json")
    public ResponseEntity<String> createTip(@Valid @RequestBody RecyclingTip tip) {
        return ResponseEntity.ok(service.createTip(tip));  // Save the new tip
    }

    // Update an existing RecyclingTip
    @PutMapping(value = "update/{id}", produces = "application/json")
    public ResponseEntity<String> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip updatedTip) {
        updatedTip.setId(id);  // Ensure the correct tip is updated
        return ResponseEntity.ok(service.updateTip(id, updatedTip));  // Update the tip
    }

    // Delete a RecyclingTip by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTip(@PathVariable Long id) {
        service.deleteTip(id);  // Delete the tip by ID
        String message = "RecyclingTip with id " + id + " has been deleted successfully!";  // Success message
        return ResponseEntity.ok(message);
    }
}
