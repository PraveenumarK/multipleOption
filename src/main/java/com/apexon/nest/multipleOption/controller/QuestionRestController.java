package com.apexon.nest.multipleOption.controller;

import com.apexon.nest.multipleOption.dto.CreateQuestionRequest;
import com.apexon.nest.multipleOption.model.Question;
import com.apexon.nest.multipleOption.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionRestController {

    @Autowired
    private QuestionService questionService;

}
