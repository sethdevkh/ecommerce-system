package com.sethdevkh.ecommerce.system.payment.service.domain.mapper;

import com.sethdevkh.ecommerce.system.payment.service.domain.dto.PaymentRequest;
import com.sethdevkh.ecommerce.system.payment.service.domain.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment paymentRequestToPayment(PaymentRequest paymentRequest);

}
