package com.moldavets.befit.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "TRAINING_EXERCISE")
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingExerciseEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TRAINING_SESSION_ID", nullable = false)
    private TrainingSessionEntity trainingSession;

    @ManyToOne
    @JoinColumn(name = "EXERCISE_TYPE_ID", nullable = false)
    private ExerciseTypeEntity exerciseType;

    @Min(1)
    private double weight;

    @Min(1)
    private int sets;

    @Min(1)
    private int repetitions;

}

