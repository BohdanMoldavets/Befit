package com.moldavets.befit.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainingExercise {

    Long id;

    @NotNull(message = "Training session is required")
    Long trainingSessionId;

    @NotNull(message = "Exercise type is required")
    Long exerciseTypeId;

    @Min(value = 1, message = "Weight must be at least 1")
    double weight;

    @Min(value = 1, message = "Sets must be at least 1")
    int sets;

    @Min(value = 1, message = "Repetitions must be at least 1")
    int repetitions;

}
