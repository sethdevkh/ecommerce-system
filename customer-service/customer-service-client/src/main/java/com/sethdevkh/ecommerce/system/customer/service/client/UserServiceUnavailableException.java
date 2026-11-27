package com.sethdevkh.ecommerce.system.customer.service.client;

public class UserServiceUnavailableException extends RuntimeException {
    public UserServiceUnavailableException(String message) {
        super(message);
    }
}
