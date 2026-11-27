package com.sethdevkh.ecommerce.system.user.service.user.dto;

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
