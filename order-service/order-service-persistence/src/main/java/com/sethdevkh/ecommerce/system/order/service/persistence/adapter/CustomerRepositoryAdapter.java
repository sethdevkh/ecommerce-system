package com.sethdevkh.ecommerce.system.order.service.persistence.adapter;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Customer;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.CustomerRepository;
import com.sethdevkh.ecommerce.system.order.service.persistence.mapper.CustomerPersistenceMapper;
import com.sethdevkh.ecommerce.system.order.service.persistence.repositoy.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerPersistenceMapper customerPersistenceMapper;

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId)
                .map(customerPersistenceMapper::customerEntityToCustomer);
    }

}
