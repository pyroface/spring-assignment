package com.example.projectarbetecomplexjavaspring.service;

import com.example.projectarbetecomplexjavaspring.entity.SubjectEntity;
import com.example.projectarbetecomplexjavaspring.entity.TeacherEntity;
import com.example.projectarbetecomplexjavaspring.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectEntity createSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public void deleteSubject(Long id) {
        SubjectEntity foundSubject = subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        subjectRepository.deleteById(foundSubject.getId());
    }

    public Iterable<SubjectEntity> findAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<SubjectEntity> findSubjectById(Long id){
        return subjectRepository.findById(id);
    }


}
