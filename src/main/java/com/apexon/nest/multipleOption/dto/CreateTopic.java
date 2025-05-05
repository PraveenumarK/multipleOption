package com.apexon.nest.multipleOption.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class CreateTopic {
    @NotBlank
    private Long subjectId;

    @NotBlank
    private String topic;


}
