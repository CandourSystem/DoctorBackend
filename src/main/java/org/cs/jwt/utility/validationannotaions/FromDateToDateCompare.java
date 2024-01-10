package org.cs.jwt.utility.validationannotaions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;



@Documented
@Constraint(validatedBy = FromDateToDateCompareValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface FromDateToDateCompare {

    String message() default "Fromdate is not less than todate !";

    String fromdate();

    String todate();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FromDateToDateCompare[] value();
    }
}