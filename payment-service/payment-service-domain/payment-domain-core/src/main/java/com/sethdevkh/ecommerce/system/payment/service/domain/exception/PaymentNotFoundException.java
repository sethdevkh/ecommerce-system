package com.sethdevkh.ecommerce.system.payment.service.domain.exception;

import com.sethdevkh.ecommerce.system.domain.exception.DomainException;

public class PaymentNotFoundException extends DomainException {
    public PaymentNotFoundException(String message) {
        super(message);
    }

    public PaymentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
