package com.devstack.ecom.upscale.dto.request;

import jakarta.persistence.*;
import lombok.*;

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
