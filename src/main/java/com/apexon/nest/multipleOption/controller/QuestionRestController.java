package com.apexon.nest.multipleOption.controller;

import com.apexon.nest.multipleOption.dto.CreateQuestionRequest;
import com.apexon.nest.multipleOption.model.Question;
import com.apexon.nest.multipleOption.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionRestController {

    @Autowired
    private QuestionService questionService;

    // POST endpoint to save question
    @PostMapping
    public ResponseEntity<?> saveQuestion(@RequestBody CreateQuestionRequest request) {
        Question savedQuestion = questionService.saveQuestion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestion);
    }

    // GET all questions (optional)
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
