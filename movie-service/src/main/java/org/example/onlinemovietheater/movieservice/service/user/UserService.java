package org.example.onlinemovietheater.movieservice.service.user;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.onlinemovietheater.movieservice.service.user.converter.grpc.UserGrpcConverter;
import org.example.onlinemovietheater.movieservice.service.user.grpc.UserGrpcService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserGrpcService userGrpcService;

    public boolean existsUserByEmail(String email) {
        return UserGrpcConverter.convert(userGrpcService.existsUserByEmail(UserGrpcConverter.convert(email)));
    }
}
