package com.sethdevkh.ecommerce.system.order.service.persistence.repositoy;

import com.sethdevkh.ecommerce.system.order.service.persistence.entity.BusinessEntity;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.BusinessEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BusinessJpaRepository extends JpaRepository<BusinessEntity, BusinessEntityId> {
    List<BusinessEntity> findByBusinessIdAndProductIdIn(UUID businessId, List<UUID> productIds);
}
