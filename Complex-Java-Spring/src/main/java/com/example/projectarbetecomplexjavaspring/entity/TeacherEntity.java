package com.example.projectarbetecomplexjavaspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeacherEntity extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private  String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<SubjectEntity> subjects = new ArrayList<>();


    public TeacherEntity(String name) {
        super();
        this.name = name;
    }

    public TeacherEntity() {
    }

    public void addSubject(SubjectEntity subjectEntity) {
        subjects.add(subjectEntity);
        subjectEntity.setTeacher(this);
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

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

}
