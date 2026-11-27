package com.sethdevkh.ecommerce.system.customer.service.client;

import lombok.Builder;

import java.sql.Date;

@Builder
public record UserResponse(
        String id,
        String username,
        Date birthDate,
        String gender,
        String mobileNumber,
        String address
) {
}
