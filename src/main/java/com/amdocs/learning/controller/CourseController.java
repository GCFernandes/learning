package com.amdocs.learning.controller;

import javax.validation.Valid;

import com.amdocs.learning.model.CourseVO;
import com.amdocs.learning.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {

    static final String REQUEST_MAPPING = "/courses";
    private static final String REQUEST_GET_COURSE = "/{id}";
    private static final String REQUEST_DELETE_COURSE = "/{id}";

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity getAllcourses() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping(REQUEST_GET_COURSE)
    public CourseVO getCourse(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @PostMapping
    public int saveCourse(@Valid @RequestBody CourseVO course) {
        return service.save(course);
    }

    @PutMapping
    public boolean updateCourse(@Valid @RequestBody CourseVO course) {
        return service.update(course);
    }

    @DeleteMapping(REQUEST_DELETE_COURSE)
    public boolean deleteCourse(@PathVariable("id") int id){
        return service.delete(id);
    }

}
