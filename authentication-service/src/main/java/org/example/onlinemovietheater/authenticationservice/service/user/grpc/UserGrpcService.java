package org.example.onlinemovietheater.authenticationservice.service.user.grpc;

import com.example.grpc.user.UserDatabaseService;
import com.example.grpc.user.UserServiceGrpc;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGrpcService {
    @GrpcClient("user-database-grpc-service")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public UserDatabaseService.UserDetailsMessage getUserDetails(UserDatabaseService.StringMessage stringMessage) throws StatusRuntimeException {
        return userServiceBlockingStub.getUserDetails(stringMessage);
    }

    public UserDatabaseService.EmptyMessage saveUser(UserDatabaseService.UserDetailsMessage userDetailsMessage) {
        return userServiceBlockingStub.saveUserDetails(userDetailsMessage);
    }

    public UserDatabaseService.BooleanMessage existsUserByEmail(UserDatabaseService.StringMessage stringMessage) {
        return userServiceBlockingStub.existsUserByEmail(stringMessage);
    }
}
