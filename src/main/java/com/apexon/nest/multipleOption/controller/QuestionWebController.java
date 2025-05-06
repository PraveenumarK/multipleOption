package com.apexon.nest.multipleOption.controller;

import com.apexon.nest.multipleOption.dto.CreateQuestionRequest;
import com.apexon.nest.multipleOption.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions")
public class QuestionWebController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/add")
    public String addQuestion(Model model) {
        model.addAttribute("question", new CreateQuestionRequest());
        return "add-question";
    }
    @PostMapping("/save")
    public String saveQuestion(@ModelAttribute CreateQuestionRequest request) {
        questionService.saveQuestion(request);
        return "redirect:/questions/add";
    }
}
