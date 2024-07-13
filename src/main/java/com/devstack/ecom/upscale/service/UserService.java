package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestUserDto;

public interface UserService {
    public void create(RequestUserDto dto, String roleType);
    public void initializeAdmin();
}
