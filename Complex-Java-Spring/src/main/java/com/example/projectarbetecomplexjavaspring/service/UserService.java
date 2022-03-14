package com.example.projectarbetecomplexjavaspring.service;

import com.example.projectarbetecomplexjavaspring.entity.RoleEntity;
import com.example.projectarbetecomplexjavaspring.entity.UserEntity;
import com.example.projectarbetecomplexjavaspring.repository.RoleRepository;
import com.example.projectarbetecomplexjavaspring.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_USER");
        userEntity.addRole(roleToAdd);
        return userRepository.save(userEntity);
    }

    public UserEntity createAdmin(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_ADMIN");
        userEntity.addRole(roleToAdd);
        return userRepository.save(userEntity);
    }

    public UserEntity createTeacher(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_TEACHER");
        userEntity.addRole(roleToAdd);
        return userRepository.save(userEntity);
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }
}
