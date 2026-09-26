package com.sethdevkh.ecommerce.system.order.service.persistence.mapper;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Customer;
import com.sethdevkh.ecommerce.system.order.service.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    @Mapping(source = "id", target = "id.value")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);

}
