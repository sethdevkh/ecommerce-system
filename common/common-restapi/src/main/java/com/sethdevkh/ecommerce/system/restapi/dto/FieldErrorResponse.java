package com.sethdevkh.ecommerce.system.restapi.dto;

public record FieldErrorResponse(
        String field,
        String code,
        String reason
) {
}
