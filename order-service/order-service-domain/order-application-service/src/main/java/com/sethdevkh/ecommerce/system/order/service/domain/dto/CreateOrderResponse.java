package com.sethdevkh.ecommerce.system.order.service.domain.dto;

import com.sethdevkh.ecommerce.system.domain.valueobject.OrderId;

public record CreateOrderResponse(
        OrderId orderId
) {
}
