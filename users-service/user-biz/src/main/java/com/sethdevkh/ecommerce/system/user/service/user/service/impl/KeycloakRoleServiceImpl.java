package com.sethdevkh.ecommerce.system.user.service.user.service.impl;

import com.sethdevkh.ecommerce.system.user.service.user.config.KCConfig;
import com.sethdevkh.ecommerce.system.user.service.user.service.KeyCloakRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakRoleServiceImpl implements KeyCloakRoleService {

    private final Keycloak keycloak;

    @Override
    public void assignRoles(String userId, String roleNameWithDelimiter) {

        String[] roleNameList = roleNameWithDelimiter.split(",");
        List<RoleRepresentation> roleRepresentationList = Arrays.stream(roleNameList)
                .map(this::getKeycloakRoleByName)
                .toList();

        keycloak.realm(KCConfig.REALM)
                .users()
                .get(userId)
                .roles()
                .realmLevel()
                .add(roleRepresentationList);
    }


    private RoleRepresentation getKeycloakRoleByName(String roleName) {
        return keycloak.realm(KCConfig.REALM)
                .roles()
                .get(roleName)
                .toRepresentation();
    }

}