package com.example.projectarbetecomplexjavaspring.controller;

import com.example.projectarbetecomplexjavaspring.entity.AdminEntity;
import com.example.projectarbetecomplexjavaspring.entity.BookEntity;
import com.example.projectarbetecomplexjavaspring.entity.StudentEntity;
import com.example.projectarbetecomplexjavaspring.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping()
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity adminEntity) {
        AdminEntity createdAdmin = adminService.createAdmin(adminEntity);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Iterable<AdminEntity>> findAllAdmins() {
        Iterable<AdminEntity> allAdmins = adminService.findAllAdmins();
        return new ResponseEntity<>(allAdmins, HttpStatus.OK);
    }
}
