package com.enviro.assessment.grad001.phillimonmotsinoni.controller;

import com.enviro.assessment.grad001.phillimonmotsinoni.model.WasteCategory;
import com.enviro.assessment.grad001.phillimonmotsinoni.service.WasteCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;
import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {
    private final WasteCategoryService wasteCategoryService;

    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;  // Dependency injection of WasteCategoryService
    }

    // Get all WasteCategories
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        return ResponseEntity.ok(wasteCategoryService.getAllCategories());  // Return list of all waste categories
    }

    // Get a single WasteCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.getCategoryById(id));  // Return waste category by ID
    }

    // Create a new WasteCategory
    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategory category) {
        return ResponseEntity.ok(wasteCategoryService.createCategory(category));  // Save and return the created waste category
    }

    // Update an existing WasteCategory
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody WasteCategory updatedCategory) {
        updatedCategory.setWasteCategoryId(id);  // Ensure we are updating the correct category by ID
        return ResponseEntity.ok(wasteCategoryService.updateCategory(updatedCategory));  // Update and return the updated waste category
    }

    // Delete a WasteCategory by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);  // This will throw an exception if the category is not found
        String message = "WasteCategory with id " + id + " has been deleted successfully!";  // Success message
        return ResponseEntity.ok(message);  // Return success message upon deletion
    }
}
