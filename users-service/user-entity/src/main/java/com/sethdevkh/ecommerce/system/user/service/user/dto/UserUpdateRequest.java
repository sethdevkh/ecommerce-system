package com.sethdevkh.ecommerce.system.user.service.user.dto;

import java.util.Date;

public record UserUpdateRequest(

        String familyName,

        String givenName,
        String address,
        Date birthDate,
        String gender,
        String mobilePhone
) {
}
