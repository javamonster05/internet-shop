package com.javamonster.internetstore.validation;


import com.javamonster.internetstore.entity.User;
import com.javamonster.internetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        User user = (User) o;
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("name", "Size.userForm.name");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("name", "Duplicate.userForm.name");
        }
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
    }
}
