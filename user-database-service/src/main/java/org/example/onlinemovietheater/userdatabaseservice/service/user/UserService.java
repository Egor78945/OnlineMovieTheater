package org.example.onlinemovietheater.userdatabaseservice.service.user;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.userdatabaseservice.model.entity.User;
import org.example.onlinemovietheater.userdatabaseservice.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long saveUser(User user) {
        return userRepository.save(user).getId();
    }

    public User getUserByEmail(String email) throws Exception {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new Exception(String.format("User with email %s hasn't found.", email)));
    }

    public boolean existsUserByEmail(String email){
        return userRepository.existsUserByEmail(email);
    }
}
