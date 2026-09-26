package com.sethdevkh.ecommerce.system.order.service.persistence.adapter;

import com.sethdevkh.ecommerce.system.order.service.domain.port.output.OrderRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.OrderEntity;
import com.sethdevkh.ecommerce.system.order.service.persistence.mapper.OrderPersistenceMapper;
import com.sethdevkh.ecommerce.system.order.service.persistence.repositoy.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order saveOrder(Order order) {
        // Map Order to OrderEntity
        OrderEntity orderEntity = orderPersistenceMapper.orderToOrderEntity(order);

        orderEntity.getOrderAddress().setOrder(orderEntity);
        orderEntity.getItems()
                .forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));

        // Save into database
        OrderEntity savedOrderEntity = orderJpaRepository.save(orderEntity);
        // Map OrderEntity to Order
        return orderPersistenceMapper.orderEntityToOrder(savedOrderEntity);
    }

}
