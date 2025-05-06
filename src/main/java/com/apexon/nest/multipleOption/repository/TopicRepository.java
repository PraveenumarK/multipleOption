package com.apexon.nest.multipleOption.repository;

import com.apexon.nest.multipleOption.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
