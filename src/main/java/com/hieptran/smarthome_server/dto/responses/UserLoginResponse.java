package com.hieptran.smarthome_server.dto.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponse {

    private UserResponse userInfo;

    private String accessToken;

    private String refreshToken;
}
