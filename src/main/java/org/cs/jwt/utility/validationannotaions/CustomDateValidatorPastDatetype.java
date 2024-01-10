package org.cs.jwt.utility.validationannotaions;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomDateValidatorPastDatetype implements ConstraintValidator<CustomDatePastDateType, Date> {

    @Override
    public void initialize(CustomDatePastDateType customDatePast) {

    }

    @Override
    public boolean isValid(Date customDateField, ConstraintValidatorContext cxt) {

        if (customDateField!=null && customDateField.compareTo(new Date()) > 0) {
            return true;
        } else {
            return false;
        }
    }

}