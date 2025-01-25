package com.enviro.assessment.grad001.phillimonmotsinoni.service;

import com.enviro.assessment.grad001.phillimonmotsinoni.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.phillimonmotsinoni.model.WasteCategory;
import com.enviro.assessment.grad001.phillimonmotsinoni.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    // Retrieve all WasteCategories
    public List<WasteCategory> getAllCategories() {
        return repository.findAll();  // Fetch all categories from the repository
    }

    // Create a new WasteCategory
    public WasteCategory createCategory(WasteCategory category) {
        return repository.save(category);  // Save the new category to the database
    }

    // Retrieve a WasteCategory by its ID
    public WasteCategory getCategoryById(Long id) {
        // If not found, throws ResourceNotFoundException
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found with ID: " + id));
    }

    // Update an existing WasteCategory
    public WasteCategory updateCategory(WasteCategory updatedCategory) {
        return repository.save(updatedCategory);  // Save the updated category to the database
    }

    // Delete a WasteCategory by ID
    public void deleteCategory(Long id) {
        WasteCategory category = getCategoryById(id);  // Ensure the category exists before deleting it
        repository.delete(category);  // Delete the found category from the repository
    }
}
