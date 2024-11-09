package org.example.onlinemovietheater.authenticationservice.service.user.security;

import com.example.grpc.user.UserDatabaseService;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.authenticationservice.configuration.jwt.JWTConfiguration;
import org.example.onlinemovietheater.authenticationservice.enumeration.user.role.UserRole;
import org.example.onlinemovietheater.authenticationservice.model.dto.security.request.AuthenticationRequestModel;
import org.example.onlinemovietheater.authenticationservice.service.user.UserService;
import org.example.onlinemovietheater.authenticationservice.service.user.grpc.UserGrpcService;
import org.example.onlinemovietheater.authenticationservice.service.user.validator.UserValidator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserGrpcService userGrpcService;
    private final JWTConfiguration jwtConfiguration;
    private final PasswordEncoder passwordEncoder;

    public String authenticate(AuthenticationRequestModel requestModel) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestModel.getEmail(), requestModel.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtConfiguration.generateToken(authentication);
    }

    public void register(AuthenticationRequestModel authenticationRequestModel) {
        if (UserValidator.isValidAuthenticationModel(authenticationRequestModel)) {
            UserDatabaseService.UserDetailsMessage userDetailsMessage = UserDatabaseService.UserDetailsMessage.newBuilder()
                    .setEmail(authenticationRequestModel.getEmail())
                    .setPassword(passwordEncoder.encode(authenticationRequestModel.getPassword()))
                    .addAllRoles(List.of(UserRole.USER_ROLE.name()))
                    .setStatus(true)
                    .build();
            try {
                userGrpcService.saveUser(userDetailsMessage);
            } catch (StatusRuntimeException e) {
                throw new RuntimeException(e.getStatus().getDescription());
            }
        }
    }
}
