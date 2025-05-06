package com.apexon.nest.multipleOption.repository;

import com.apexon.nest.multipleOption.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    // Custom queries can go here if needed
}
