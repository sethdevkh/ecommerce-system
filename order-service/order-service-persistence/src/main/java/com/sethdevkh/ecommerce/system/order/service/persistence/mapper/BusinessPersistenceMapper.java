package com.sethdevkh.ecommerce.system.order.service.persistence.mapper;

import com.sethdevkh.ecommerce.system.domain.valueobject.BusinessId;
import com.sethdevkh.ecommerce.system.domain.valueobject.Money;
import com.sethdevkh.ecommerce.system.domain.valueobject.ProductId;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Product;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.BusinessEntity;
import com.sethdevkh.ecommerce.system.persistence.business.exception.BusinessPersistenceException;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface BusinessPersistenceMapper {

    default List<UUID> businessToBusinessProducts(Business business) {
        return business.getProducts().stream()
                .map(product -> product.getId().value())
                .toList();
    }

    default Business businessEntityToBusiness(List<BusinessEntity> businessEntities) {
        BusinessEntity businessEntity = businessEntities.stream()
                .findFirst()
                .orElseThrow(() -> new BusinessPersistenceException("Business could not be found"));

        List<Product> businessProducts = businessEntities.stream()
                .map(entity -> Product.builder()
                        .id(new ProductId(entity.getProductId()))
                        .name(entity.getProductName())
                        .price(new Money(entity.getProductPrice()))
                        .build())
                .toList();

        return Business.builder()
                .id(new BusinessId(businessEntity.getBusinessId()))
                .products(businessProducts)
                .active(businessEntity.getBusinessActive())
                .build();
    }

}