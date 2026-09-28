package com.sethdevkh.ecommerce.system.payment.service.domain.ports.output.repository;

import com.sethdevkh.ecommerce.system.domain.valueobject.CustomerId;
import com.sethdevkh.ecommerce.system.payment.service.domain.entity.CreditEntry;

import java.util.Optional;

public interface CreditEntryRepository {

    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
