package org.example.onlinemovietheater.authenticationservice.service.user.converter.grpc;

import com.example.grpc.user.UserDatabaseService;
import org.example.onlinemovietheater.authenticationservice.model.security.UserDetailsImplementation;

public class UserGrpcConverter {
    public static UserDetailsImplementation convert(UserDatabaseService.UserDetailsMessage userDetailsMessage) {
        return new UserDetailsImplementation(userDetailsMessage.getEmail(), userDetailsMessage.getPassword(), userDetailsMessage.getRolesList());
    }

    public static UserDatabaseService.StringMessage convert(String message) {
        return UserDatabaseService.StringMessage
                .newBuilder()
                .setString(message)
                .build();
    }
}
