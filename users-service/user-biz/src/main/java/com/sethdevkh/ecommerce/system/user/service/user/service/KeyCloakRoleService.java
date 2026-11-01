package com.sethdevkh.ecommerce.system.user.service.user.service;

public interface KeyCloakRoleService {
    void assignRoles(String userId, String roleNameWithDelimiter);
}
