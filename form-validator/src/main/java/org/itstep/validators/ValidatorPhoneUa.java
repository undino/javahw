package org.itstep.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidatorPhoneUa implements ConstraintValidator<PhoneUa, Integer> {

    public void initialize(PhoneUa constraint) {

    }

    public boolean isValid(Integer phoneNumber, ConstraintValidatorContext context) {
       return Pattern.matches("^[6975]\\d{8}", phoneNumber.toString());
    }
}
