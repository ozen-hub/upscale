package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestUserRoleDto;
import com.devstack.ecom.upscale.entity.UserRole;
import com.devstack.ecom.upscale.repo.RoleRepo;
import com.devstack.ecom.upscale.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void initializerUserRoles() {
        List<UserRole> list = roleRepo.findAll();
        if (list.isEmpty()){
            roleRepo.saveAll(List.of(
                    UserRole.builder().roleId(UUID.randomUUID().toString())
                            .roleName("USER").description("Description").build(),
                    UserRole.builder().roleId(UUID.randomUUID().toString())
                            .roleName("CUSTOMER").description("Description").build(),
                    UserRole.builder().roleId(UUID.randomUUID().toString())
                            .roleName("ADMIN").description("Description").build(),
                    UserRole.builder().roleId(UUID.randomUUID().toString())
                            .roleName("MANAGER").description("Description").build()
            ));
        }

    }
}
