package com.apexon.nest.multipleOption.repository;

import com.apexon.nest.multipleOption.model.Topic;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    /*Optional<Topic> findByTopic(String topicName);*/

    Optional<Topic> findByTopicName(String topicName);
}
