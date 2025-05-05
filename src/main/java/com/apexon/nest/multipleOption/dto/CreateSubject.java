package com.apexon.nest.multipleOption.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class CreateSubject {
    @NotBlank
    private String subject;
}
