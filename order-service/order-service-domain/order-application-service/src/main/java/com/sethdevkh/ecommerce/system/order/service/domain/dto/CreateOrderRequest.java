package com.sethdevkh.ecommerce.system.order.service.domain.dto;

import com.sethdevkh.ecommerce.system.domain.valueobject.BusinessId;
import com.sethdevkh.ecommerce.system.domain.valueobject.CustomerId;
import com.sethdevkh.ecommerce.system.domain.valueobject.Money;
import com.sethdevkh.ecommerce.system.domain.valueobject.StreetAddress;

public record CreateOrderRequest(
        CustomerId customerId,
        BusinessId businessId,
        StreetAddress deliveryAddress,
        Money price
) {
}
