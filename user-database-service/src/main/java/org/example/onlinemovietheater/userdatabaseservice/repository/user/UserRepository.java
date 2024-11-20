package org.example.onlinemovietheater.userdatabaseservice.repository.user;

import org.example.onlinemovietheater.userdatabaseservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    @Query("SELECT CASE WHEN EXISTS(SELECT id from User where email=?1) THEN TRUE ELSE FALSE END")
    Boolean existsUserByEmail(String email);
}
