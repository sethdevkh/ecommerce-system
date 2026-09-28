package com.sethdevkh.ecommerce.system.payment.service.domain.ports.output.message.publisher;

import com.sethdevkh.ecommerce.system.payment.service.domain.outbox.OutboxStatus;
import com.sethdevkh.ecommerce.system.payment.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

public interface PaymentResponseMessagePublisher {
    void publish(OrderOutboxMessage orderOutboxMessage,
                 BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);
}
