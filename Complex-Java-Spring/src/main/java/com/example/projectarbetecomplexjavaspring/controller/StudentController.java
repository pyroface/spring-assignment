package com.example.projectarbetecomplexjavaspring.controller;

import com.example.projectarbetecomplexjavaspring.entity.StudentEntity;
import com.example.projectarbetecomplexjavaspring.entity.SubjectEntity;
import com.example.projectarbetecomplexjavaspring.entity.TeacherEntity;
import com.example.projectarbetecomplexjavaspring.exceptions.NoContentException;
import com.example.projectarbetecomplexjavaspring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity) {
        StudentEntity createdStudent = studentService.createStudent(studentEntity);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<StudentEntity>> findAllStudents() {
        Iterable<StudentEntity> allStudents = studentService.findAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<StudentEntity>> findStudentById(@PathVariable Long id) {
        Optional<StudentEntity> foundStudent = studentService.findStudentById(id);
        String message = "Couldn't find student with requested ID";
        if (foundStudent.isEmpty()) {
            throw new NoContentException(message);
        } else {
            return new ResponseEntity<>(foundStudent, HttpStatus.OK);
        }
    }
}
