package com.devstack.ecom.upscale.dto.request;

import lombok.*;

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
