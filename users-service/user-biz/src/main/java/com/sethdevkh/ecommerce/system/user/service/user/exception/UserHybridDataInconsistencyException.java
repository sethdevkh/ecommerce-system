package com.sethdevkh.ecommerce.system.user.service.user.exception;


import com.sethdevkh.ecommerce.system.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UserHybridDataInconsistencyException extends GlobalException {
    public UserHybridDataInconsistencyException(HttpStatus status, String message) {
        super(status, message);
    }
}
