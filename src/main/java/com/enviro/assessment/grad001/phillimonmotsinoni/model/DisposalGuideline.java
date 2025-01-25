package com.enviro.assessment.grad001.phillimonmotsinoni.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wasteCategoryId", nullable = false)
    @JsonBackReference
    private WasteCategory wasteCategory;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
