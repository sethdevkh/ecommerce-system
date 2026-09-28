package com.sethdevkh.ecommerce.system.payment.service.domain.ports.input.message.listener;

import com.sethdevkh.ecommerce.system.payment.service.domain.dto.PaymentRequest;

public interface PaymentRequestMessageListener {
    void completePayment(PaymentRequest paymentRequest);

    void cancelPayment(PaymentRequest paymentRequest);
}
