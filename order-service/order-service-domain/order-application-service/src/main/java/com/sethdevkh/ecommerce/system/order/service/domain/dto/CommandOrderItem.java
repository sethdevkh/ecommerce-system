package com.sethdevkh.ecommerce.system.order.service.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CommandOrderItem(
        UUID productId,
        Integer quantity,
        BigDecimal price,
        BigDecimal subTotal
) {
}
