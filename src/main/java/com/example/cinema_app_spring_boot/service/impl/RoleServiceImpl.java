package com.example.cinema_app_spring_boot.service.impl;

import com.example.cinema_app_spring_boot.model.Role;
import com.example.cinema_app_spring_boot.repository.RoleRepository;
import com.example.cinema_app_spring_boot.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(Role.RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
