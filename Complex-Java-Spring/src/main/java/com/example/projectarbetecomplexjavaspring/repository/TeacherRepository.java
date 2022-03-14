package com.example.projectarbetecomplexjavaspring.repository;

import com.example.projectarbetecomplexjavaspring.entity.AdminEntity;
import com.example.projectarbetecomplexjavaspring.entity.RoleEntity;
import com.example.projectarbetecomplexjavaspring.entity.TeacherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {
   // RoleEntity findByRole(String role);
    TeacherEntity findTeacherByUsername (String username);
}
