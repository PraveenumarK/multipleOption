package com.apexon.nest.multipleOption.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String topic;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
