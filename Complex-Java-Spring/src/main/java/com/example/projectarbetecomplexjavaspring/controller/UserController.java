package com.example.projectarbetecomplexjavaspring.controller;

import com.example.projectarbetecomplexjavaspring.entity.UserEntity;
import com.example.projectarbetecomplexjavaspring.exceptions.UnauthorizedException;
import com.example.projectarbetecomplexjavaspring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("signup")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("createadmin")
    public ResponseEntity<UserEntity> createAdmin(@RequestBody UserEntity user) {
        UserEntity createdAdmin = userService.createAdmin(user);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @PostMapping("createteacher")
    public ResponseEntity<UserEntity> createTeacher(@RequestBody UserEntity user) {
        UserEntity createdTeacher = userService.createTeacher(user);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<UserEntity>> findAllUsers() {
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        String message = "Not authorized";
        try {
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (UnauthorizedException ue) {
            throw new UnauthorizedException(message);
        }
    }

}
