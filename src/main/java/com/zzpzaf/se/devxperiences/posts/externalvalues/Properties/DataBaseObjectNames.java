package com.zzpzaf.se.devxperiences.posts.externalvalues.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;



@ConfigurationProperties(prefix="set1")
@Validated
public class DataBaseObjectNames {
    
    //@NotEmpty
    private String categoriesTable;
    @NotEmpty
    private String itemsTable;
    @NotEmpty
    private String vendorsTable;
    @NotEmpty
    private String vendorCategoriesTable;


    public  DataBaseObjectNames(@DefaultValue("categories") String categoriesTable, String itemsTable, String vendorsTable, String vendorCategoriesTable) {
        this.categoriesTable=categoriesTable;
        this.itemsTable=itemsTable;
        this.vendorsTable=vendorsTable;
        this.vendorCategoriesTable=vendorCategoriesTable;
    } 

    public String getCategoriesTable() {
        return categoriesTable;
    }

    public String getItemsTable() {
        return itemsTable;
    }

    public String getVendorsTable() {
        return vendorsTable;
    }

    public String getVendorCategoriesTable() {
        return vendorCategoriesTable;
    }


}
