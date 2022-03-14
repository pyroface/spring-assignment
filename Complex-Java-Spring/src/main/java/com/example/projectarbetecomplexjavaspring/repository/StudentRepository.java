package com.example.projectarbetecomplexjavaspring.repository;

import com.example.projectarbetecomplexjavaspring.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    StudentEntity findStudentByUsername (String username);
}
