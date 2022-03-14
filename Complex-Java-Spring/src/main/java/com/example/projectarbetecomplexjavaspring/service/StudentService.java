package com.example.projectarbetecomplexjavaspring.service;

import com.example.projectarbetecomplexjavaspring.entity.StudentEntity;
import com.example.projectarbetecomplexjavaspring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long id) {
        StudentEntity foundStudent = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        studentRepository.deleteById(foundStudent.getId());
    }

    public Iterable<StudentEntity> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

}
