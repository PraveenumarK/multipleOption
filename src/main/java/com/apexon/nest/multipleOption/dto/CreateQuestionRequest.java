package com.apexon.nest.multipleOption.dto;

import com.apexon.nest.multipleOption.model.Option;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateQuestionRequest {
    @NotBlank
    private Long topic;

    @NotBlank
    private String description;

    @NotBlank
    private String explanation;

    @NotBlank
    private List<Option> options;

}
