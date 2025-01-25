package com.enviro.assessment.grad001.phillimonmotsinoni.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wasteCategoryId;

    @NotBlank(message = "Category name is mandatory")
    @Size(max = 100, message = "Category name must be less than 100 characters")
    private String name;

    @OneToMany(mappedBy = "wasteCategory", orphanRemoval = true)
    @JsonManagedReference
    private List<DisposalGuideline> guidelines;

    @OneToMany(mappedBy = "wasteCategory", orphanRemoval = true)
    @JsonManagedReference
    private List<RecyclingTip> recyclingTips;

    // Getters and Setters

    public Long getWasteCategoryId() {
        return wasteCategoryId;
    }

    public void setWasteCategoryId(Long wasteCategoryId) {
        this.wasteCategoryId = wasteCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DisposalGuideline> getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(List<DisposalGuideline> guidelines) {
        this.guidelines = guidelines;
    }

    public List<RecyclingTip> getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(List<RecyclingTip> recyclingTips) {
        this.recyclingTips = recyclingTips;
    }
}
