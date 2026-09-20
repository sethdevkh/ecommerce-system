package com.sethdevkh.ecommerce.system.order.service.persistence.repositoy;

import com.sethdevkh.ecommerce.system.order.service.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
}
