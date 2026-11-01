package com.sethdevkh.ecommerce.system.user.service.user.mapper;

import com.sethdevkh.ecommerce.system.user.service.user.dto.UserCreateRequest;
import com.sethdevkh.ecommerce.system.user.service.user.dto.UserResponse;
import com.sethdevkh.ecommerce.system.user.service.user.dto.UserUpdateRequest;
import com.sethdevkh.ecommerce.system.user.service.user.entity.UserEntity;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserCreateRequest userCreateRequest);
    UserResponse toResponse(UserEntity userEntity);

    @Mapping(source = "familyName", target = "firstName")
    @Mapping(source = "givenName", target = "lastName")
    UserRepresentation toRepresentation(UserCreateRequest userCreateRequest);

    default UserResponse toResponse(UserEntity userEntity, UserRepresentation userRepresentation) {
        return  UserResponse.builder()
                .id(userEntity.getId())
                .username(userRepresentation.getUsername())
                .birthDate(userEntity.getBirthDate())
                .gender(userEntity.getGender())
                .mobileNumber(userEntity.getMobilePhone())
                .address(userEntity.getAddress())
                .build();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toEntity(UserUpdateRequest request, @MappingTarget UserEntity entity);
}
