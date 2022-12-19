package edu.university.finals.polyclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emailExistsExceptionHandler(EmailExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notFoundExceptionHandler(NotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String constraintViolationExceptionHandler(BindException e) {
        return Objects.requireNonNull(e.getBindingResult()
                .getFieldError())
                .getField()
                + " "
                + e.getBindingResult()
                .getFieldError()
                .getDefaultMessage();
    }
}
