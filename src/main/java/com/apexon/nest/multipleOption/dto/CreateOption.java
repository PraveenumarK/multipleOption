package com.apexon.nest.multipleOption.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateOption {

    private Long questionId;

    @NotBlank
    private boolean isCorrect;


    private String explanation;

    @NotBlank
    private String description;
}
