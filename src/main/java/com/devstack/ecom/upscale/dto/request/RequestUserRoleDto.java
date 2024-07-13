package com.devstack.ecom.upscale.dto.request;

import com.devstack.ecom.upscale.entity.UserRoleHasUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Builder
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestUserRoleDto {
    @Column(name = "role_name", length = 100, unique = true)
    private String roleName;

    @Column(name = "description", length = 100)
    private String description;
}
