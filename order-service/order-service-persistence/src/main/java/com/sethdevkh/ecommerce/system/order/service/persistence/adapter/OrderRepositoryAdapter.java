package com.sethdevkh.ecommerce.system.order.service.persistence.adapter;

import com.sethdevkh.ecommerce.system.order.service.domain.port.output.OrderRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.OrderEntity;
import com.sethdevkh.ecommerce.system.order.service.persistence.mapper.OrderPersistenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = orderPersistenceMapper.orderToOrderEntity(order);
        entityManager.persist(orderEntity);
        return orderPersistenceMapper.orderEntityToOrder(orderEntity);
    }
}
