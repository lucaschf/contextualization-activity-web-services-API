package tsi.ws.lucaschfonseca.introductionwebservices.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormErrorDto> handle(MethodArgumentNotValidException exception) {
        List<FormErrorDto> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            errors.add(new FormErrorDto(e.getField(), message));
        });

        return errors;
    }
}
