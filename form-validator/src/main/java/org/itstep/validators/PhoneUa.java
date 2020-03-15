package org.itstep.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = ValidatorPhoneUa.class)
public @interface PhoneUa {

    String message() default "PhoneUa";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
