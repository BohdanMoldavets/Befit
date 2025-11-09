package com.moldavets.befit.repository;

import com.moldavets.befit.model.entity.TrainingExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingExerciseRepository extends JpaRepository<TrainingExerciseEntity, Long> {
}
