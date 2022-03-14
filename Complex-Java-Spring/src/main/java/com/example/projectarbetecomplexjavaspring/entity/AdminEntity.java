package com.example.projectarbetecomplexjavaspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AdminEntity extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;

    public AdminEntity(String username, String password, Set<RoleEntity> roles, String name) {
        super(username, password, roles);
        this.name = name;
    }

    public AdminEntity(String name) {
        this.name = name;
    }

    public AdminEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
