package com.sethdevkh.ecommerce.system.customer.service.client;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserCreateRequest(
        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        String password,

        @NotBlank(message = "Confirm Password is required")
        String confirmPassword,

        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Family Name is required")
        String familyName,

        String givenName,
        String roleName
) {
}
