package com.sethdevkh.ecommerce.system.order.service.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

// JPA Entity must be a POJO class (Plain Old Java Object)
// setter, getter, no-arg
@Getter
@Setter
@NoArgsConstructor
@IdClass(BusinessEntityId.class)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusinessEntity that = (BusinessEntity) o;
        return Objects.equals(businessId, that.businessId)
                && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessId, productId);
    }
}
