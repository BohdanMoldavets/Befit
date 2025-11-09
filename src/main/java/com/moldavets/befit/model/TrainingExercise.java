package com.moldavets.befit.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TrainingExercise(
        Long id,

        @NotNull(message = "Training session is required")
        Long trainingSessionId,

        @NotNull(message = "Exercise type is required")
        Long exerciseTypeId,

        @Min(value = 1, message = "Weight must be at least 1")
        double weight,

        @Min(value = 1, message = "Sets must be at least 1")
        int sets,

        @Min(value = 1, message = "Repetitions must be at least 1")
        int repetitions
) {
}
