package com.amdocs.learning.controller;

import javax.validation.Valid;

import com.amdocs.learning.model.AdminVO;
import com.amdocs.learning.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admins")
public class AdminController {

    static final String REQUEST_MAPPING = "/admins";
    private static final String REQUEST_GET_ADMIN = "/{id}";
    private static final String REQUEST_DELETE_ADMIN = "/{id}";

    @Autowired
    private AdminService service;

    @GetMapping
    public ResponseEntity getAllAdmins() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping(REQUEST_GET_ADMIN)
    public AdminVO getAdmins(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @PostMapping
    public int saveAdmin(@Valid @RequestBody AdminVO admin) {
        return service.save(admin);
    }

    @PutMapping
    public boolean updateUser(@Valid @RequestBody AdminVO admin) {
        return service.update(admin);
    }

    @DeleteMapping(REQUEST_DELETE_ADMIN)
    public boolean deleteUser(@PathVariable("id") int id){
        return service.delete(id);
    }

}
