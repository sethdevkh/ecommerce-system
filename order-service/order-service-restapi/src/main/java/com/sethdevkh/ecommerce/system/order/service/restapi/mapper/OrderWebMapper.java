package com.sethdevkh.ecommerce.system.order.service.restapi.mapper;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderResult;
import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateRequest;
import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {

    @Mapping(source = "orderAddress", target = "deliveryAddress")
    CreateOrderCommand orderCreateRequestToCreateOrderCommand(OrderCreateRequest orderCreateRequest);
    OrderCreateResponse createOrderResultToOrderCreateResponse(CreateOrderResult createOrderResult);
}
