package com.apexon.nest.multipleOption.repository;

import com.apexon.nest.multipleOption.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
