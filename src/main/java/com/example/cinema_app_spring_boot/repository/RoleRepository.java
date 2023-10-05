package com.example.cinema_app_spring_boot.repository;

import com.example.cinema_app_spring_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("From Role r Where r.roleName = ?1")
    Role findByRoleName(Role.RoleName roleName);
}
