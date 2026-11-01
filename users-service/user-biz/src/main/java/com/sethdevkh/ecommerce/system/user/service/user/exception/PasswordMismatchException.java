package com.sethdevkh.ecommerce.system.user.service.user.exception;

import com.sethdevkh.ecommerce.system.restapi.exception.GlobalException;
import com.sethdevkh.ecommerce.system.restapi.exception.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;

public class PasswordMismatchException extends GlobalException {
    public PasswordMismatchException(HttpStatus status, String message) {
        super(status, message);
    }
}