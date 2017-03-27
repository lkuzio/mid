package xyz.javista.controlpanel.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

/**
 * Created by Luke on 2017-03-27.
 */
@ControllerAdvice
public class ValidatorHandler {

    protected static final Logger LOGGER = LoggerFactory.getLogger(RuntimeExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public void handleRuntimeException(ValidationException ex) {
        LOGGER.error("Validation exception", ex);
    }
}
