package com.enviro.assessment.grad001.phillimonmotsinoni.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tip is mandatory")
    private String tip;

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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}
