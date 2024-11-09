package org.example.onlinemovietheater.authenticationservice.service.user;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.authenticationservice.model.dto.security.request.AuthenticationRequestModel;
import org.example.onlinemovietheater.authenticationservice.service.user.converter.grpc.UserGrpcConverter;
import org.example.onlinemovietheater.authenticationservice.service.user.grpc.UserGrpcService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserGrpcService userGrpcService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return UserGrpcConverter.convert(userGrpcService.getUserDetails(UserGrpcConverter.convert(username)));
        } catch (StatusRuntimeException e){
            throw new UsernameNotFoundException(e.getStatus().getDescription());
        }
    }
}
