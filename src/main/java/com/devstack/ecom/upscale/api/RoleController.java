package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestUserDto;
import com.devstack.ecom.upscale.dto.request.RequestUserRoleDto;
import com.devstack.ecom.upscale.service.UserRoleService;
import com.devstack.ecom.upscale.service.UserService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestUserRoleDto dto) {
        userRoleService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"role was created!..",null),
                HttpStatus.CREATED
        );
    }
}
