package com.amdocs.learning.controller;

import javax.validation.Valid;

import com.amdocs.learning.model.UserVO;

import com.amdocs.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    static final String REQUEST_MAPPING = "/users";
    private static final String REQUEST_GET_USER = "/{id}";
    private static final String REQUEST_DELETE_USER = "/{id}";

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping(REQUEST_GET_USER)
    public UserVO getUsers(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @PostMapping
    public int saveUser(@Valid @RequestBody UserVO user) {
        return service.save(user);
    }

    @PutMapping
    public boolean updateUser(@Valid @RequestBody UserVO user) {
        return service.update(user);
    }

    @DeleteMapping(REQUEST_DELETE_USER)
    public boolean deleteUser(@PathVariable("id") int id){
        return service.delete(id);
    }

}
