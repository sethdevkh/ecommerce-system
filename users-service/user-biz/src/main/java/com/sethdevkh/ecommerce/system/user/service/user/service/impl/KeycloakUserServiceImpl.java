package com.sethdevkh.ecommerce.system.user.service.user.service.impl;

import com.sethdevkh.ecommerce.system.user.service.user.config.KCConfig;
import com.sethdevkh.ecommerce.system.user.service.user.exception.KeycloakException;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakUserServiceImpl implements com.sethdevkh.ecommerce.system.user.service.user.service.KeycloakUserService {

    private final Keycloak keycloak;

    @Override
    public void createKeycloakUser(UserRepresentation userRepresentation) {
        try (Response response = keycloak.realm(KCConfig.REALM)
                .users()
                .create(userRepresentation)) {
            if (response.getStatus() != HttpStatus.CREATED.value()) {
                throw new KeycloakException(
                        HttpStatus.valueOf(response.getStatus()),
                        "Create user in keycloak failed with status " + response.getStatus()
                );
            }
        }
    }

    @Override
    public UserRepresentation getKeycloakUserByUsername(String username) {
        return keycloak.realm(KCConfig.REALM)
                .users()
                .search(username, true)
                .stream()
                .findFirst()
                .orElseThrow(() -> new KeycloakException(
                        HttpStatus.NOT_FOUND,
                        "User in Keycloak not found"
                ));
    }


    @Override
    public void updateKeycloakUser(String id, UserRepresentation userRepresentation) {
        try {
            keycloak.realm(KCConfig.REALM)
                    .users()
                    .get(id)
                    .update(userRepresentation);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    @Override
    public UserRepresentation getKeycloakUserById(String id) {
        return keycloak.realm(KCConfig.REALM)
                .users()
                .get(id)
                .toRepresentation();
    }


    @Override
    public Slice<UserRepresentation> getKeycloakUsersByRoleName(String roleName, Pageable pageable) {
        List<UserRepresentation> userRepresentationList = keycloak.realm(KCConfig.REALM)
                .roles()
                .get(roleName)
                .getUserMembers((int) pageable.getOffset(), pageable.getPageSize() + 1);

        boolean hasNext = userRepresentationList.size() > pageable.getPageSize();
        List<UserRepresentation> content = hasNext ? userRepresentationList.subList(0, pageable.getPageSize()) : userRepresentationList;
        return new SliceImpl<>(content, pageable, hasNext);
    }


    @Override
    public Slice<UserRepresentation> getKeycloakUsers(Pageable pageable) {
        List<UserRepresentation> userRepresentationList = keycloak.realm(KCConfig.REALM)
                .users()
                .list((int) pageable.getOffset(), pageable.getPageSize() + 1);

        boolean hasNext = userRepresentationList.size() > pageable.getPageSize();
        List<UserRepresentation> content = hasNext ? userRepresentationList.subList(0, pageable.getPageSize()) : userRepresentationList;
        return new SliceImpl<>(content, pageable, hasNext);
    }


    @Override
    public void deleteKeycloakUserById(String id) {
        try (Response response = keycloak.realm(KCConfig.REALM)
                .users()
                .delete(id)) {
            if (response.getStatus() != HttpStatus.NO_CONTENT.value()) {
                throw new KeycloakException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Delete user in keycloak failed with status " + response.getStatus()
                );
            }
        }
    }
}