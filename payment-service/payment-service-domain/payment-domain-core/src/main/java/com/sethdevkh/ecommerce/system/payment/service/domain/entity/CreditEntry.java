package com.sethdevkh.ecommerce.system.payment.service.domain.entity;

import com.sethdevkh.ecommerce.system.domain.entity.BaseEntity;
import com.sethdevkh.ecommerce.system.domain.valueobject.CustomerId;
import com.sethdevkh.ecommerce.system.domain.valueobject.Money;
import com.sethdevkh.ecommerce.system.payment.service.domain.valueobject.CreditEntryId;

public class CreditEntry extends BaseEntity<CreditEntryId> {
    private final CustomerId customerId;
    private Money totalCreditAmount;

    public void addCreditAmount(Money amount) {
        totalCreditAmount = totalCreditAmount.add(amount);
    }

    public void subtractCreditAmount(Money amount) {
        totalCreditAmount = totalCreditAmount.subtract(amount);
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public Money getTotalCreditAmount() {
        return totalCreditAmount;
    }

    private CreditEntry(Builder builder) {
        super.setId(builder.id);
        customerId = builder.customerId;
        totalCreditAmount = builder.totalCreditAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CreditEntryId id;
        private CustomerId customerId;
        private Money totalCreditAmount;

        private Builder() {
        }

        public Builder id(CreditEntryId val) {
            id = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder totalCreditAmount(Money val) {
            totalCreditAmount = val;
            return this;
        }

        public CreditEntry build() {
            return new CreditEntry(this);
        }
    }
}
