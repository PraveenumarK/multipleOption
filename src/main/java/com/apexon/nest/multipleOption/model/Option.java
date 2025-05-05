package com.apexon.nest.multipleOption.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isCorrect;

    private String explanation;

    private String description;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;



}
