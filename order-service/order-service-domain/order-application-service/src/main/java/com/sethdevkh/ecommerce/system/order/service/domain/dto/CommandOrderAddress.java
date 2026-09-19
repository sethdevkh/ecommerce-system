package com.sethdevkh.ecommerce.system.order.service.domain.dto;

public record CommandOrderAddress(
        String street,
        String postalCode,
        String city
) {
}
