package com.example.cinema_app_spring_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public enum RoleName {
        USER("USER"),
        ADMIN("ADMIN");

        private String roleName;

        RoleName(String roleName) {
            this.roleName = roleName;
        }
    }

}
