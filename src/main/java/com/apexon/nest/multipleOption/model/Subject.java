package com.apexon.nest.multipleOption.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    private String subject; // ✅ This is just the name of the subject, don't annotate with @OneToMany

    @OneToMany(mappedBy = "subject")
    private List<Topic> topics; // ✅ This is the correct use of @OneToMany
}

