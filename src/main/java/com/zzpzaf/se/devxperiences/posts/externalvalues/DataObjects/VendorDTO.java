package com.zzpzaf.se.devxperiences.posts.externalvalues.DataObjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.lang.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VendorDTO {
    
    @NonNull
    @NotBlank
    private String vendorName="";


    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(@NotNull String vendorName) {
        this.vendorName = vendorName;
    }
    
}
