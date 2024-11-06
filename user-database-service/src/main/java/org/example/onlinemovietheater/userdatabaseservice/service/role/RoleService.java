package org.example.onlinemovietheater.userdatabaseservice.service.role;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.userdatabaseservice.model.entity.Role;
import org.example.onlinemovietheater.userdatabaseservice.repositories.role.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Long saveRole(Role role){
        return roleRepository.save(role).getId();
    }

    public List<Role> getRolesByUserId(Long id){
        return roleRepository.findAllByUserId(id);
    }
}
