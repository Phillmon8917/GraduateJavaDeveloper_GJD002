package com.enviro.assessment.grad001.phillimonmotsinoni.service;

import com.enviro.assessment.grad001.phillimonmotsinoni.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.phillimonmotsinoni.model.DisposalGuideline;
import com.enviro.assessment.grad001.phillimonmotsinoni.model.WasteCategory;
import com.enviro.assessment.grad001.phillimonmotsinoni.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.phillimonmotsinoni.utils.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;
    @Autowired
    private WasteCategoryService wasteCategoryService;

    // Get all DisposalGuidelines
    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();  // Retrieve all guidelines from the repository
    }

    // Create a new DisposalGuideline
    public String createGuideline(DisposalGuideline guideline) {
        WasteCategory wasteCategory = wasteCategoryService.getCategoryById(guideline.getWasteCategory().getWasteCategoryId());
        return JsonConverter.covertJson(repository.save(guideline), wasteCategory);  // Save and convert to JSON
    }

    // Get a DisposalGuideline by ID
    public DisposalGuideline getGuidelineById(Long id) {
        // If not found, throw ResourceNotFoundException
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found with ID: " + id));
    }

    // Update an existing DisposalGuideline
    public String updateGuideline(Long id, DisposalGuideline updatedGuideline) {
        // Fetch the existing guideline. If not found, throw exception
        DisposalGuideline existingGuideline = getGuidelineById(id);
        WasteCategory wasteCategory = wasteCategoryService.getCategoryById(existingGuideline.getWasteCategory().getWasteCategoryId());

        existingGuideline.setDescription(updatedGuideline.getDescription());  // Update description field
        return JsonConverter.covertJson(repository.save(existingGuideline), wasteCategory);  // Save and return the updated guideline
    }

    // Delete a DisposalGuideline
    public void deleteGuideline(Long id) {
        // If not found, throw exception
        DisposalGuideline guideline = getGuidelineById(id);
        repository.delete(guideline);  // Delete the found guideline
    }

}
