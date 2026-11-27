package com.sethdevkh.ecommerce.system.customer.service.client;

import com.sethdevkh.ecommerce.system.restapi.dto.FieldErrorResponse;
import com.sethdevkh.ecommerce.system.restapi.dto.RestApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.ServiceUnavailableException;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceUnavailableException.class)
    public RestApiErrorResponse<?> handleException(
            ServiceUnavailableException e
    ) {
        return RestApiErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                //.detail(extractFieldErrors(e.getFieldErrors()))
                .build();
    }

    private List<FieldErrorResponse> extractFieldErrors(
            List<FieldError> fieldErrors
    ) {
        return fieldErrors.stream()
                .map(fieldError -> new FieldErrorResponse(
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getDefaultMessage()
                ))
                .toList();
    }

}
