package com.apexon.nest.multipleOption.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateSubject {

    @NotBlank
    private String subjectName;

    private List<CreateTopic> topics;
}
