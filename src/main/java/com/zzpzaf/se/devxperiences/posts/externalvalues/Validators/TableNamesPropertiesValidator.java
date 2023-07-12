package com.zzpzaf.se.devxperiences.posts.externalvalues.Validators;

// import java.text.DateFormat.Field;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.zzpzaf.se.devxperiences.posts.externalvalues.Properties.DataBaseObjectNames;

public class TableNamesPropertiesValidator implements Validator{
    

    // List<String> TableNamesContained = new ArrayList<>(Arrays.asList("categories","items","vendors","vendorcategories"));
    public enum BasicTableNamesEnum {
        categories,
        items, 
        vendors,
        vendorcategories; 
    }


   // Overriding org.springframework.validation.Validator interface methods
    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'supports'");
        return DataBaseObjectNames.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'validate'");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoriesTable", "msg.error.field.content");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemsTable", "field.required");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vendorsTable", "field.required");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vendorCategoriesTable", "field.required");
        
        DataBaseObjectNames tableNames = (DataBaseObjectNames) target;

        String cat = tableNames.getCategoriesTable();
        String catBasic = BasicTableNamesEnum.categories.toString();

        if (cat != null && !cat.toLowerCase().contains(catBasic)) {
            errors.rejectValue("categoriesTable", "msg.error.field.content",  new Object[]{catBasic},
            "The table-name must contain the '" + catBasic + "' word.");
        } 



    }



}
