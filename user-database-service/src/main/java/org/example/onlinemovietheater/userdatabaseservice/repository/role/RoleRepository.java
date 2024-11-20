package org.example.onlinemovietheater.userdatabaseservice.repository.role;

import org.example.onlinemovietheater.userdatabaseservice.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByUserId(Long id);
}
