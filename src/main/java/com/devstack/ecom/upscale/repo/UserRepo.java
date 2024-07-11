package com.devstack.ecom.upscale.repo;

import com.devstack.ecom.upscale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
