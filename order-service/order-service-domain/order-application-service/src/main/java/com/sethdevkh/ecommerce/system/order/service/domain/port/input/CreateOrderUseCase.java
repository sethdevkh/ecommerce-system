package com.sethdevkh.ecommerce.system.order.service.domain.port.input;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {
    void execute(CreateOrderRequest createOrderRequest);
}
