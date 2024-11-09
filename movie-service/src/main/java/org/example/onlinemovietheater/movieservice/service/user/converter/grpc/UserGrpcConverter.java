package org.example.onlinemovietheater.movieservice.service.user.converter.grpc;

import com.example.grpc.user.UserDatabaseService;

public class UserGrpcConverter {
    public static UserDatabaseService.StringMessage convert(String message){
        return UserDatabaseService.StringMessage
                .newBuilder()
                .setString(message)
                .build();
    }
    public static boolean convert(UserDatabaseService.BooleanMessage message){
        return message.getBoolean();
    }
}
