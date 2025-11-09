package com.moldavets.befit.repository;

import com.moldavets.befit.model.entity.ExerciseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseTypeRepository extends JpaRepository<ExerciseTypeEntity, Long> {
}
