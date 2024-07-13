package com.devstack.ecom.upscale.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name="user_role_has_user")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleHasUser {

    @EmbeddedId
    private UserRoleHasUserKey idUserRoleHasUserKey = new UserRoleHasUserKey();

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("userRole")
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;
}
