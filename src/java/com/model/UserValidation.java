/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author josemiguel
 */
public class UserValidation implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User users = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name",
                "required.first_name", "El campo Nombr es es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name",
                "required.last_name", "El campo Apellidos es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "required.email", "El campo Email es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone_number",
                "required.phone_number", "El campo Teléfono es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
                "required.gender", "El campo Género es obligatorio.");

        if (!(users.getEmail() != null && users.getEmail().isEmpty())) {

            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(users.getEmail());

            if (!matcher.matches()) {
                errors.rejectValue("email", "email.incorrect",
                        "El correo electrónico"
                        + users.getEmail()
                        + " no es válido");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "phone_number",
                "required.phone_number",
                "El campo Teléfono es Obligatorio.");

    }

}
