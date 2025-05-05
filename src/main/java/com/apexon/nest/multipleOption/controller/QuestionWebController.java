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

    // Load all questions and display in list
    @GetMapping
    public String getAllQuestions(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "question-list"; // your HTML: question-list.html
    }

    // Show Add Question form
    @GetMapping("/add")
    public String showAddQuestionForm(Model model) {
        model.addAttribute("question", new CreateQuestionRequest());
        return "add-question"; // your HTML: add-question.html
    }

    // Handle form submission
    @PostMapping("/add")
    public String addQuestion(@ModelAttribute("question") CreateQuestionRequest createQuestionRequest) {
        questionService.addQuestion(createQuestionRequest);
        return "redirect:/questions"; // Go back to list after saving
    }

    // Optional: Delete question by ID
    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "redirect:/questions";
    }
}
