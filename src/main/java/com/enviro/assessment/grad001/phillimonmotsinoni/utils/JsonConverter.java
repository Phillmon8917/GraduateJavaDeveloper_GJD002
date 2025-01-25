package com.enviro.assessment.grad001.phillimonmotsinoni.utils;

import com.enviro.assessment.grad001.phillimonmotsinoni.model.DisposalGuideline;
import com.enviro.assessment.grad001.phillimonmotsinoni.model.RecyclingTip;
import com.enviro.assessment.grad001.phillimonmotsinoni.model.WasteCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    // Convert the object to JSON and merge with WasteCategory JSON
    public static String covertJson(Object object, WasteCategory wasteCategory) {
        ObjectMapper obj = new ObjectMapper();
        String firstJson = "";
        StringBuilder stringToMerge = new StringBuilder();

        try {

            // Convert object to JSON based on its type (either DisposalGuideline or RecyclingTip)
            if (object instanceof DisposalGuideline) {
                DisposalGuideline disposalGuideline = (DisposalGuideline) object;
                firstJson = obj.writeValueAsString(disposalGuideline);
            } else {
                RecyclingTip recyclingTip = (RecyclingTip) object;
                firstJson = obj.writeValueAsString(recyclingTip);
            }

            // Merge the two JSON strings
            stringToMerge.append(firstJson.substring(0, firstJson.length() - 1) + ",");
            stringToMerge.append(obj.writeValueAsString(wasteCategory).substring(1));
        } catch (Exception e) {
            e.fillInStackTrace();  // Handle exceptions without throwing
        }

        return stringToMerge.toString();  // Return the merged JSON string
    }
}
