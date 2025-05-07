package com.apexon.nest.multipleOption.controller;

import com.apexon.nest.multipleOption.model.Subject;
import com.apexon.nest.multipleOption.service.SubjectService;
import com.apexon.nest.multipleOption.vo.SubjectTopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @PostMapping ("/api/subjects")
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        Subject response = subjectService.saveSubject(subject);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/api/get/subjectid/{subjectid}")
    public ResponseEntity<Subject> getSubjectWithTopics(@PathVariable Long subjectid) {
        Subject response = subjectService.getSubjectWithTopics(subjectid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
