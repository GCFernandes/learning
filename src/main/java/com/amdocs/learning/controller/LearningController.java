package com.amdocs.learning.controller;

import static com.amdocs.learning.controller.LearningController.REQUEST_MAPPING;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(REQUEST_MAPPING)
public class LearningController {

    static final String REQUEST_MAPPING = "/learning";

    @GetMapping
    public String hello() {
        return "Hello";
    }

}
