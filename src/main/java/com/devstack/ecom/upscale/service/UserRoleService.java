package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestUserRoleDto;

public interface UserRoleService {
    public void create(RequestUserRoleDto dto);
    public void initializerUserRoles();
}
