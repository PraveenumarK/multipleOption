package com.apexon.nest.multipleOption.repository;

import com.apexon.nest.multipleOption.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
