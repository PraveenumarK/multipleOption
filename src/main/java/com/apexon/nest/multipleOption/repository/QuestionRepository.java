package com.apexon.nest.multipleOption.repository;

import com.apexon.nest.multipleOption.model.Question;
import com.apexon.nest.multipleOption.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
