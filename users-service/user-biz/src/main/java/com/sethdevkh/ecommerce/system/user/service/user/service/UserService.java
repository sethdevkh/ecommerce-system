package com.sethdevkh.ecommerce.system.user.service.user.service;

import com.sethdevkh.ecommerce.system.restapi.dto.PageResponse;
import com.sethdevkh.ecommerce.system.user.service.user.dto.UserCreateRequest;
import com.sethdevkh.ecommerce.system.user.service.user.dto.UserResponse;
import com.sethdevkh.ecommerce.system.user.service.user.dto.UserUpdateRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);

    void deleteById(String id);

    UserResponse getByUsername(String username);

    PageResponse<UserResponse> getUsersByRoleName(String roleName, Pageable pageable);

    PageResponse<UserResponse> getUsers(PageRequest of);

}