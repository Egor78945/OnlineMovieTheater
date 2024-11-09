package org.example.onlinemovietheater.movieservice.service.user.grpc;

import com.example.grpc.user.UserDatabaseService;
import com.example.grpc.user.UserServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGrpcService {
    @GrpcClient("user-database-grpc-service")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public UserDatabaseService.BooleanMessage existsUserByEmail(UserDatabaseService.StringMessage request){
        return userServiceBlockingStub.existsUserByEmail(request);
    }
}
