package com.sethdevkh.ecommerce.system.order.service.domain.port.output;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
