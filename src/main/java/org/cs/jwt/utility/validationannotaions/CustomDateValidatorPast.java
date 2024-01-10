package org.cs.jwt.utility.validationannotaions;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomDateValidatorPast implements ConstraintValidator<CustomDatePast, String> {

   private String patternmatcher;
   
    @Override
    public void initialize(CustomDatePast customDatePast) {
        this.patternmatcher=customDatePast.pattern();
    }

    @Override
    public boolean isValid(String customDateField, ConstraintValidatorContext cxt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patternmatcher);
        try {
            sdf.setLenient(false);
            Date d = sdf.parse(customDateField);
            if(d.compareTo(new Date())>0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (ParseException e) {
            return false;
        }
    }

}