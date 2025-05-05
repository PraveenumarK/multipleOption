package com.apexon.nest.multipleOption.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class CreateOption {
    @NotBlank
    private Long questionId;

    @NotBlank
    private boolean isCorrect;

    @NotBlank
    private String explanation;

    @NotBlank
    private String description;
}
