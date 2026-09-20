package com.sethdevkh.ecommerce.system.order.service.domain.port.output;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {
    Optional<Business> findBusinessInformation(Business business);
}
