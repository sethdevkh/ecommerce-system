package com.sethdevkh.ecommerce.system.order.service.domain.dto;

import java.util.UUID;

public record CreateOrderResult(
        UUID orderId
) {
}
