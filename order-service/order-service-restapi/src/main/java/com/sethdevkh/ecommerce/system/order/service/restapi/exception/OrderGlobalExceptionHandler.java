package com.sethdevkh.ecommerce.system.order.service.restapi.exception;

import com.sethdevkh.ecommerce.system.order.service.domain.exception.OrderDomainException;
import com.sethdevkh.ecommerce.system.persistence.business.exception.BusinessPersistenceException;
import com.sethdevkh.ecommerce.system.restapi.dto.RestApiErrorResponse;
import com.sethdevkh.ecommerce.system.restapi.exception.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderGlobalExceptionHandler extends GlobalExceptionHandler {
    // TODO: Write your exception handler when error occurred

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OrderDomainException.class)
    public RestApiErrorResponse<?> handleOrderDomainException(OrderDomainException ex
    ) {
        return RestApiErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessPersistenceException.class)
    public RestApiErrorResponse<?> handleBusinessPersistenceException(BusinessPersistenceException ex
    ) {
        return RestApiErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }

}
