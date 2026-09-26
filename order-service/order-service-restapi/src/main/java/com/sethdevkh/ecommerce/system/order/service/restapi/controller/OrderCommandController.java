package com.sethdevkh.ecommerce.system.order.service.restapi.controller;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderResult;
import com.sethdevkh.ecommerce.system.order.service.domain.usecase.CreateOrderUseCase;
import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateRequest;
import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateResponse;
import com.sethdevkh.ecommerce.system.order.service.restapi.mapper.OrderWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    private final CreateOrderUseCase createOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(
            @Valid @RequestBody OrderCreateRequest orderCreateRequest
    ) {
        // Mapping logic
        CreateOrderCommand createOrderCommand = orderWebMapper
                .orderCreateRequestToCreateOrderCommand(orderCreateRequest);

        // UseCase logic
        CreateOrderResult createOrderResult = createOrderUseCase.execute(createOrderCommand);

        // Mapping logic
        return orderWebMapper.createOrderResultToOrderCreateResponse(createOrderResult);
    }

}
