package org.example.onlinemovietheater.userdatabaseservice.service.converter.user.grpc;


import com.example.grpc.user.UserDatabaseService;
import org.example.onlinemovietheater.userdatabaseservice.model.entity.Role;
import org.example.onlinemovietheater.userdatabaseservice.model.entity.User;

import java.util.List;

public class UserGrpcConverter {
    public static User convert(UserDatabaseService.UserDetailsMessage userDetailsMessage){
        return new User(userDetailsMessage.getEmail(), userDetailsMessage.getPassword(), userDetailsMessage.getStatus());
    }

    public static UserDatabaseService.StringMessage convert(String string){
        return UserDatabaseService.StringMessage
                .newBuilder()
                .setString(string)
                .build();
    }

    public static UserDatabaseService.UserDetailsMessage convert(User user, List<Role> roles){
        return UserDatabaseService.UserDetailsMessage
                .newBuilder()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .addAllRoles(roles
                        .stream()
                        .map(r -> r.toString())
                        .toList())
                .setStatus(user.getAccountStatus())
                .build();
    }
}
