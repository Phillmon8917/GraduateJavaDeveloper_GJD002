package com.enviro.assessment.grad001.phillimonmotsinoni.config;

import com.enviro.assessment.grad001.phillimonmotsinoni.model.WasteCategory;
import com.enviro.assessment.grad001.phillimonmotsinoni.repository.WasteCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Configuration
public class CommandLineAppRunner {

    // Logger to log database connection issues
    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppRunner.class);

    @Bean
    public CommandLineRunner initializeDatabase(WasteCategoryRepository repository) {
        return args -> {
            List<String> categories = List.of(
                    "Organic Waste", "Recyclable Waste", "Hazardous Waste",
                    "Electronic Waste", "General Waste"
            );

            for (String name : categories) {
                try {
                    // Check if the category already exists
                    if (repository.findAll().stream().noneMatch(c -> c.getName().equalsIgnoreCase(name))) {
                        // Save the new category to the database
                        WasteCategory category = new WasteCategory();
                        category.setName(name);
                        repository.save(category);
                    }
                } catch (Exception e) {
                    // Log the error with category name and exception message
                    logger.error("Database connection failed while saving category '{}'. Error: {}", name, e.getMessage());

                    // Throwing a custom exception with a generic message
                    throw new RuntimeException("There was an issue connecting to the database.");
                }
            }
        };
    }
}
