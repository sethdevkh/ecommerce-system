package com.sethdevkh.ecommerce.system.order.service.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

// JPA Entity must be a POJO class (Plain Old Java Object)
// setter, getter, no-arg
@Getter
@Setter
@NoArgsConstructor
@IdClass(BusinessEntity.class)
@Entity
@Table(name = "businesses")
public class BusinessEntity {
    @Id
    private UUID businessId;
    @Id
    private UUID productId;

    private Boolean businessActive;
    private String productName;
    private BigDecimal productPrice;
}
