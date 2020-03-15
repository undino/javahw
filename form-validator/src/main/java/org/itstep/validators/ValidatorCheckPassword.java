package org.itstep.validators;

import org.itstep.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "passwordValidator")
public class ValidatorCheckPassword implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (!user.getPassword().equals(user.getCheckPassword())) {
            errors.rejectValue("password", "CheckPassword");
            errors.rejectValue("checkPassword", "CheckPassword");
        }

    }
}
