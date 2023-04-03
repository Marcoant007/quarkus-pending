package br.quarkusspending.com.utils;

import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import br.quarkusspending.com.exceptions.MessageExceptions;


@ApplicationScoped
public class ValidatorUtil {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(Object obj) {
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        if (!violations.isEmpty()) {
            String message = violations.stream().map(cv -> cv.getMessage()).collect(Collectors.joining("&"));
            throw new MessageExceptions(message, 422);
        }
    }
}
