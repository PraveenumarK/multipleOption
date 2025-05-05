package com.apexon.nest.multipleOption.controller;

import com.apexon.nest.multipleOption.dto.QuestionRequest;
import com.apexon.nest.multipleOption.model.Question;
import com.apexon.nest.multipleOption.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Question>> getQuestionsByTopic(@PathVariable String topic) {
        return ResponseEntity.ok(questionService.getQuestionsByTopic(topic));
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@Valid @RequestBody QuestionRequest request) {
        return ResponseEntity.ok(questionService.addQuestion(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
