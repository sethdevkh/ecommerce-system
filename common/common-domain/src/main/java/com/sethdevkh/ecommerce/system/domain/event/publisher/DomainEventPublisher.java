package com.sethdevkh.ecommerce.system.domain.event.publisher;

import com.sethdevkh.ecommerce.system.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
