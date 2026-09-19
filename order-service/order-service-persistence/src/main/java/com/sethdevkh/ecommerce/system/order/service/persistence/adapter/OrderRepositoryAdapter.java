package com.sethdevkh.ecommerce.system.order.service.persistence.adapter;

import com.sethdevkh.ecommerce.system.order.service.domain.port.output.OrderRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.persistence.repositoy.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order saveOrder(Order order) {
        return null;
    }
}
