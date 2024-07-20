package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.auth.ApplicationUser;
import com.devstack.ecom.upscale.entity.User;
import com.devstack.ecom.upscale.entity.UserRole;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.devstack.ecom.upscale.security.ApplicationUserRole.*;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> selectedUser = userRepo.findByEmail(username);
        if(selectedUser.isEmpty()){
            throw new EntryNotFoundException(String.format("username %s not found",username));
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();


        for(UserRole u:selectedUser.get().getRoles()){
            if (u.getRoleName().equals("USER")){
                grantedAuthorities.addAll(USER.grantedAuthorities());
            }
            if (u.getRoleName().equals("CUSTOMER")){
                grantedAuthorities.addAll(CUSTOMER.grantedAuthorities());
            }
            if (u.getRoleName().equals("ADMIN")){
                grantedAuthorities.addAll(ADMIN.grantedAuthorities());
            }
            if (u.getRoleName().equals("MANAGER")){
                grantedAuthorities.addAll(MANAGER.grantedAuthorities());
            }
        }

        return new ApplicationUser(
                grantedAuthorities,
                selectedUser.get().getPassword(),
                selectedUser.get().getEmail(),
                selectedUser.get().isAccountNonExpired(),
                selectedUser.get().isAccountNonLocked(),
                selectedUser.get().isCredentialsNonExpired(),
                selectedUser.get().isEnabled()
        );

    }
}
