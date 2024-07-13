package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface RoleRepo extends CrudRepository<UserRole,String> {

    @Query(nativeQuery = true, value = "SELECT * FROM user_role WHERE role_name=?1")
    Optional<UserRole> findUserRoleByRoleName(String role);

    @Query(nativeQuery = true, value = "SELECT * FROM user_role")
    List<UserRole> findAll();
}
