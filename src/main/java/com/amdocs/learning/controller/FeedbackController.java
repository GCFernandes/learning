package com.amdocs.learning.controller;

import javax.validation.Valid;

import com.amdocs.learning.model.FeedbackVO;
import com.amdocs.learning.service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/feedbacks")
public class FeedbackController {

    static final String REQUEST_MAPPING = "/feedbacks";
    private static final String REQUEST_GET_FEEDBACK = "/{id}";
    private static final String REQUEST_DELETE_FEEDBACK= "/{id}";

    @Autowired
    private FeedbackService service;

    @GetMapping
    public ResponseEntity getAllFeedbacks() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping(REQUEST_GET_FEEDBACK)
    public FeedbackVO getFeedbacks(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @PostMapping
    public int saveFeedback(@Valid @RequestBody FeedbackVO Feedback) {
        return service.save(Feedback);
    }

    @PutMapping
    public boolean updateUser(@Valid @RequestBody FeedbackVO Feedback) {
        return service.update(Feedback);
    }

    @DeleteMapping(REQUEST_DELETE_FEEDBACK)
    public boolean deleteUser(@PathVariable("id") int id){
        return service.delete(id);
    }

}
