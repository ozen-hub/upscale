package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestUserRoleDto;
import com.devstack.ecom.upscale.entity.UserRole;
import com.devstack.ecom.upscale.repo.RoleRepo;
import com.devstack.ecom.upscale.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final RoleRepo roleRepo;

    @Override
    public void create(RequestUserRoleDto dto) {
        UserRole build = UserRole.builder().roleId(UUID.randomUUID().toString()).roleName(dto.getRoleName())
                .description(dto.getDescription()).build();
        roleRepo.save(build);
    }
}
