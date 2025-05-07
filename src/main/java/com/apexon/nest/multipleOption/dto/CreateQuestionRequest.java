package com.apexon.nest.multipleOption.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateQuestionRequest {
    @NotBlank
    private Long topicId;

    @NotBlank
    private String topicName;

    @NotBlank
    private String description;

    @NotBlank
    private String explanation;

    @NotBlank
    private List<CreateOption> options;

}
