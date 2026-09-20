package com.sethdevkh.ecommerce.system.order.service.persistence.mapper;

import com.sethdevkh.ecommerce.system.domain.valueobject.BusinessId;
import com.sethdevkh.ecommerce.system.domain.valueobject.CustomerId;
import com.sethdevkh.ecommerce.system.domain.valueobject.Money;
import com.sethdevkh.ecommerce.system.domain.valueobject.ProductId;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Customer;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Product;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.BusinessEntity;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = CustomerId.class)
public interface OrderPersistenceMapper {

    @Mapping(target = "id", expression = "java(new CustomerId(customerEntity.getId()))")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);

    default List<UUID> businessToProductIds(Business business) {
        return business.getProducts().stream()
                .map(product -> product.getId().value())
                .toList();
    }

    default Business businessEntitiesToBusiness(List<BusinessEntity> businessEntities) {
        BusinessEntity businessEntity = businessEntities.getFirst();

        List<Product> products = businessEntities.stream()
                .map(entity -> Product.Builder.builder()
                        .id(new ProductId(entity.getProductId()))
                        .name(entity.getProductName())
                        .price(new Money(entity.getProductPrice()))
                        .build())
                .toList();

        return Business.Builder.builder()
                .id(new BusinessId(businessEntity.getBusinessId()))
                .products(products)
                .active(Boolean.TRUE.equals(businessEntity.getBusinessActive()))
                .build();
    }
}
