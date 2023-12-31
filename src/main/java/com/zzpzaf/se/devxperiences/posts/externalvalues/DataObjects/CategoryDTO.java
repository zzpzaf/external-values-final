package com.zzpzaf.se.devxperiences.posts.externalvalues.DataObjects;

import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO {
    
    @NonNull
    @NotBlank
    private String categoryName="";


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
}
