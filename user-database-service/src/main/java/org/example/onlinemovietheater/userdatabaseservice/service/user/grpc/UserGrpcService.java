package org.example.onlinemovietheater.userdatabaseservice.service.user.grpc;

import com.example.grpc.user.UserDatabaseService;
import com.example.grpc.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.onlinemovietheater.userdatabaseservice.model.entity.Role;
import org.example.onlinemovietheater.userdatabaseservice.model.entity.User;
import org.example.onlinemovietheater.userdatabaseservice.service.converter.user.grpc.UserGrpcConverter;
import org.example.onlinemovietheater.userdatabaseservice.service.role.RoleService;
import org.example.onlinemovietheater.userdatabaseservice.service.user.UserService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {
    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void getUserDetails(UserDatabaseService.StringMessage request, StreamObserver<UserDatabaseService.UserDetailsMessage> responseObserver) {
        User user = userService.getUserByEmail(request.getString());
        List<Role> roles = roleService.getRolesByUserId(user.getId());
        responseObserver.onNext(UserGrpcConverter.convert(user, roles));
        responseObserver.onCompleted();
    }

    @Override
    public void saveUserDetails(UserDatabaseService.UserDetailsMessage request, StreamObserver<UserDatabaseService.StringMessage> responseObserver) {
        Long userId = userService.saveUser(UserGrpcConverter.convert(request));
        for (String role : request.getRolesList()) {
            roleService.saveRole(new Role(userId, role));
        }
        responseObserver.onNext(UserGrpcConverter.convert(request.getEmail()));
    }
}
