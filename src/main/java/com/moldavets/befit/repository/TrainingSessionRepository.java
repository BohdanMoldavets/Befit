package com.moldavets.befit.repository;

import com.moldavets.befit.model.entity.TrainingSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingSessionRepository extends JpaRepository<TrainingSessionEntity, Long> {
}
