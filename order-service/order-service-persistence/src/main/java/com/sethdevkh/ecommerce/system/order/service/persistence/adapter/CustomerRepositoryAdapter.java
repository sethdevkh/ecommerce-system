package com.sethdevkh.ecommerce.system.order.service.persistence.adapter;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Customer;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.CustomerRepository;
import com.sethdevkh.ecommerce.system.order.service.persistence.mapper.OrderPersistenceMapper;
import com.sethdevkh.ecommerce.system.order.service.persistence.repositoy.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId)
                .map(orderPersistenceMapper::customerEntityToCustomer);
    }
}
