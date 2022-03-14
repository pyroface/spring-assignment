package com.example.projectarbetecomplexjavaspring.service;

import com.example.projectarbetecomplexjavaspring.entity.LibraryEntity;
import com.example.projectarbetecomplexjavaspring.entity.TeacherEntity;
import com.example.projectarbetecomplexjavaspring.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherEntity createTeacher(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }

    public void deleteTeacher(Long id) {
        TeacherEntity foundTeacher = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        teacherRepository.deleteById(foundTeacher.getId());
    }

    public Iterable<TeacherEntity> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<TeacherEntity> findTeacherById(Long id){
        return teacherRepository.findById(id);
    }
}
