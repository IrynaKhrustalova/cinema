package com.example.cinema_app_spring_boot.service;

import com.example.cinema_app_spring_boot.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(Role.RoleName roleName);
}
