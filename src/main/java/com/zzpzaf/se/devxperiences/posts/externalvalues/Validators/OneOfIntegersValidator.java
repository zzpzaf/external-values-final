package com.zzpzaf.se.devxperiences.posts.externalvalues.Validators;

import java.util.Arrays;
import java.util.stream.IntStream;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OneOfIntegersValidator implements ConstraintValidator<OneOfIntegers, Integer>{

    Integer[] arrayOfValues; 


    // Overriding jakarta.validation.ConstraintValidator interface methods
    @Override
    public void initialize(OneOfIntegers constraintAnnotation) {
        int[] values = constraintAnnotation.Values();
        this.arrayOfValues = IntStream.of( values ).boxed().toArray( Integer[]::new );

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        //arrayOfValues = new Integer[] {2, 17, 33, 5, 28}; 
        return  Arrays.asList(this.arrayOfValues).contains(value);
    }


 

}

