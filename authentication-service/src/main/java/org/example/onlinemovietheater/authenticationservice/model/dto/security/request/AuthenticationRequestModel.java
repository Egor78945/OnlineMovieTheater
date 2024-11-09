package org.example.onlinemovietheater.authenticationservice.model.dto.security.request;

import lombok.Data;

@Data
public class AuthenticationRequestModel {
    private String email;
    private String password;
}
