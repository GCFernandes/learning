package com.amdocs.learning.controller;

import javax.validation.Valid;

import com.amdocs.learning.model.ContactVO;
import com.amdocs.learning.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/contacts")
public class ContactController {

    static final String REQUEST_MAPPING = "/contacts";
    private static final String REQUEST_GET_CONTACT = "/{id}";
    private static final String REQUEST_DELETE_CONTACT = "/{id}";

    @Autowired
    private ContactService service;

    @GetMapping
    public ResponseEntity getAllContacts() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping(REQUEST_GET_CONTACT)
    public ContactVO getContacts(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @PostMapping
    public int saveContact(@Valid @RequestBody ContactVO contact) {
        return service.save(contact);
    }

    @PutMapping
    public boolean updateContact(@Valid @RequestBody ContactVO contact) {
        return service.update(contact);
    }

    @DeleteMapping(REQUEST_DELETE_CONTACT)
    public boolean deleteContact(@PathVariable("id") int id){
        return service.delete(id);
    }

}
