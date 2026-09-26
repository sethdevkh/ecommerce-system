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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OrderDomainException.class)
    public RestApiErrorResponse<?> handleOrderDomainException(OrderDomainException e) {
        return RestApiErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessPersistenceException.class)
    public RestApiErrorResponse<?> handleOrderPersistenceException(BusinessPersistenceException e) {
        return RestApiErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(e.getMessage())
                .build();
    }

}
