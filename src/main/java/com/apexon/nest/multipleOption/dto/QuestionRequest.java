package com.apexon.nest.multipleOption.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuestionRequest {
    @NotBlank
    private String topic;

    @NotBlank
    private String description;

    @NotBlank
    private String optionA;

    @NotBlank
    private String optionB;

    @NotBlank
    private String optionC;

    @NotBlank
    private String optionD;

    @NotBlank
    private String correctOption; // A, B, C, or D

    @NotBlank
    private String explanation;
}
