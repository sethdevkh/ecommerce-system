package com.sethdevkh.ecommerce.system.order.service.persistence.adapter;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.BusinessRepository;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.BusinessEntity;
import com.sethdevkh.ecommerce.system.order.service.persistence.mapper.OrderPersistenceMapper;
import com.sethdevkh.ecommerce.system.order.service.persistence.repositoy.BusinessJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BusinessRepositoryAdapter implements BusinessRepository {

    private final BusinessJpaRepository businessJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Optional<Business> findBusinessInformation(Business business) {
        List<UUID> productIds = orderPersistenceMapper.businessToProductIds(business);
        List<BusinessEntity> businessEntities = businessJpaRepository
                .findByBusinessIdAndProductIdIn(business.getId().value(), productIds);

        if (businessEntities == null || businessEntities.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(orderPersistenceMapper.businessEntitiesToBusiness(businessEntities));
    }
}
