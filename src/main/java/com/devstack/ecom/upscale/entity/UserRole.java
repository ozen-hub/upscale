package com.devstack.ecom.upscale.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name="user_role")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    @Id
    @Column(name = "role_id", length = 80)
    private String roleId;

    @Column(name = "role_name", length = 100)
    private String roleName;

    @Column(name = "description", length = 100)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
