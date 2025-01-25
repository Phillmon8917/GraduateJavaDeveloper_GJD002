package com.enviro.assessment.grad001.phillimonmotsinoni.service;

import com.enviro.assessment.grad001.phillimonmotsinoni.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.phillimonmotsinoni.model.RecyclingTip;
import com.enviro.assessment.grad001.phillimonmotsinoni.model.WasteCategory;
import com.enviro.assessment.grad001.phillimonmotsinoni.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.phillimonmotsinoni.utils.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;
    @Autowired
    private WasteCategoryService wasteCategoryService;

    // Retrieve all RecyclingTips
    public List<RecyclingTip> getAllTips() {
        return recyclingTipRepository.findAll();  // Get all tips from the repository
    }

    // Create a new RecyclingTip
    public String createTip(RecyclingTip tip) {
        WasteCategory wasteCategory = wasteCategoryService.getCategoryById(tip.getWasteCategory().getWasteCategoryId());
        return JsonConverter.covertJson(recyclingTipRepository.save(tip), wasteCategory);  // Save and convert to JSON
    }

    // Retrieve a RecyclingTip by its ID
    public RecyclingTip getTipById(Long id) {
        // If not found, throw ResourceNotFoundException
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found with ID: " + id));
    }

    // Update an existing RecyclingTip by ID
    public String updateTip(Long id, RecyclingTip updatedTip) {
        // Fetch the existing tip. If not found, throws exception
        RecyclingTip existingTip = getTipById(id);
        existingTip.setTip(updatedTip.getTip());  // Update the tip content

        WasteCategory wasteCategory = wasteCategoryService.getCategoryById(existingTip.getWasteCategory().getWasteCategoryId());
        return JsonConverter.covertJson(recyclingTipRepository.save(existingTip), wasteCategory);  // Save and return the updated tip
    }

    // Delete a RecyclingTip by ID
    public void deleteTip(Long id) {
        // Ensure tip exists before deleting it
        RecyclingTip tip = getTipById(id);
        recyclingTipRepository.delete(tip);  // Delete the found tip
    }
}
