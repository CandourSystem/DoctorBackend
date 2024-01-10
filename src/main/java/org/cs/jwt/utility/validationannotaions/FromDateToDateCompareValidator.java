package org.cs.jwt.utility.validationannotaions;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FromDateToDateCompareValidator implements ConstraintValidator<FromDateToDateCompare, Object> {

    private String fromDate;
    private String toDate;

    public void initialize(FromDateToDateCompare constraintAnnotation) {
        this.fromDate = constraintAnnotation.fromdate();
        this.toDate = constraintAnnotation.todate();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Object fromDateValue = new BeanWrapperImpl(value).getPropertyValue(fromDate);
        Object toDateValue = new BeanWrapperImpl(value).getPropertyValue(toDate);

        if (fromDateValue == null || toDateValue == null || ((Date) fromDateValue).compareTo((Date) toDateValue) > 0) {
            return false;
        } else {
            return true;
        }
    }

}