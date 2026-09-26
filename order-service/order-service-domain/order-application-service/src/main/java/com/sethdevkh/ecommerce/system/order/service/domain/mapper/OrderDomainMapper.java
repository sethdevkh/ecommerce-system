package com.sethdevkh.ecommerce.system.order.service.domain.mapper;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CommandOrderItem;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDomainMapper {

    @Mapping(source = "customerId", target = "customerId.value")
    @Mapping(source = "businessId", target = "businessId.value")
    @Mapping(source = "price", target = "price.amount")
    Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand);

    @Mapping(source = "productId", target = "product.id.value")
    @Mapping(source = "price", target = "price.amount")
    @Mapping(source = "subTotal", target = "subTotal.amount")
    OrderItem commandOrderItemToOrderItem(CommandOrderItem commandOrderItem);

}
