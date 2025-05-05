package com.apexon.nest.multipleOption.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "subject")
    private String subject;

}
