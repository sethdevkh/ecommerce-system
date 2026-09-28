package com.sethdevkh.ecommerce.system.order.service.domain.ports.output;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {
    Optional<Business> findBusiness(Business business);
}
