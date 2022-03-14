package com.example.projectarbetecomplexjavaspring;

import com.example.projectarbetecomplexjavaspring.entity.*;
import com.example.projectarbetecomplexjavaspring.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class ProjectarbeteComplexJavaSpringApplication {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(ProjectarbeteComplexJavaSpringApplication.class, args);

    }

    @Bean
    public CommandLineRunner setUpRoles(RoleRepository roleRepository) {
        return (args) -> {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_TEACHER"));
            roleRepository.save(new RoleEntity("ROLE_USER"));
        };
    }

    // Generate data at startup
    @Bean
    public CommandLineRunner setUpData(
            LibraryRepository libraryRepository,
            BookRepository bookRepository,
            TeacherRepository teacherRepository,
            SubjectRepository subjectRepository,
            StudentRepository studentRepository) {
        return (args) -> {

            //LIBRARY & BOOK TEST DATA
//            LibraryEntity library1 = new LibraryEntity("lib");
//            BookEntity book1 = new BookEntity("It", "horror", "222-111");
//            library1.addBook(book1);
//            libraryRepository.save(library1);
//
//            //TEACHER & SUBJECT TEST DATA
//            TeacherEntity teacher1 = new TeacherEntity("Pontus");
//            SubjectEntity subject1 = new SubjectEntity("Math");
//            teacher1.addSubject(subject1);
//            teacherRepository.save(teacher1);

            //STUDENT TEST DATA
            //StudentEntity student1 = new StudentEntity("Leo", passwordEncoder.encode("secret"), "ROLE_USER", "Leoe", "leo@mail.com");
            //student1.addSubject(subject1);
            //studentRepository.save(student1);

        };
    }

}
