package com.sethdevkh.ecommerce.system.order.service.persistence.repositoy;

import com.sethdevkh.ecommerce.system.order.service.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
}
