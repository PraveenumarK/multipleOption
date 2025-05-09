package com.apexon.nest.multipleOption.repository;

import com.apexon.nest.multipleOption.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
