package com.apexon.nest.multipleOption.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTopic {

    @NotBlank
    private Long subjectId;

    @NotBlank
    private String topicName;
}
