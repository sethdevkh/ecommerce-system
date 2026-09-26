package com.sethdevkh.ecommerce.system.order.service.domain.usecase;

import com.sethdevkh.ecommerce.system.domain.valueobject.BusinessId;
import com.sethdevkh.ecommerce.system.domain.valueobject.ProductId;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderResult;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Product;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderCreatedEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.exception.OrderDomainException;
import com.sethdevkh.ecommerce.system.order.service.domain.mapper.OrderDomainMapper;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.BusinessRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.CustomerRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.OrderRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;
    private final OrderDomainService orderDomainService;
    private final OrderDomainMapper orderDomainMapper;

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("Create Order Request: {}", createOrderCommand);

        // validate customer
        customerRepository.findCustomer(createOrderCommand.customerId())
                .orElseThrow(() -> new OrderDomainException("Customer Not Found"));

        // validate business
        List<Product> products = createOrderCommand.items().stream()
                .map(commandOrderItem -> Product.builder()
                        .id(new ProductId(commandOrderItem.productId()))
                        .build())
                .toList();

        Business business = Business.builder()
                .id(new BusinessId(createOrderCommand.businessId()))
                .products(products)
                .build();

        business = businessRepository.findBusiness(business)
                .orElseThrow(()  -> new OrderDomainException("Business Not Found"));

        Order order = orderDomainMapper.createOrderCommandToOrder(createOrderCommand);

        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, business);
        Order initiatedOrder = orderCreatedEvent.getOrder();

        log.info("Order Created: {}", initiatedOrder);

        Order savedOrder = orderRepository.saveOrder(initiatedOrder);

        if (savedOrder == null) {
            throw new OrderDomainException("Order Not Saved");
        }

        return new CreateOrderResult(savedOrder.getId().value());
    }
}
