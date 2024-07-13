package com.devstack.ecom.upscale.dto.request;

import com.devstack.ecom.upscale.entity.UserRoleHasUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
    private String email;
    private String displayName;
    private String password;
}
