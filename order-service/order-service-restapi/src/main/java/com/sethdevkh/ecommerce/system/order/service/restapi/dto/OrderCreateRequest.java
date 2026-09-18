package com.sethdevkh.ecommerce.system.order.service.restapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record OrderCreateRequest(
        @NotNull
        UUID customerId,
        @NotNull
        UUID businessId,
        @NotNull
        OrderAddressRequest orderAddress,
        @NotNull
        BigDecimal price,
        @NotNull
        List<OrderItemRequest> items
) {
}
