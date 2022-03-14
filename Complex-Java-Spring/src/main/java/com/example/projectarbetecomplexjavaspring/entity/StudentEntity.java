package com.example.projectarbetecomplexjavaspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class StudentEntity extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    private String email;

    @ManyToMany
    private List<SubjectEntity> subjects = new ArrayList<>();

    public StudentEntity(String username, String password, Set<RoleEntity> roles, String name, String email) {
        super(username, password, roles);
        this.name = name;
        this.email = email;
    }

    public StudentEntity() {
    }

    public void addSubject(SubjectEntity subjectEntity) {
        subjects.add(subjectEntity);
        subjectEntity.getStudents().add(this);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

}

