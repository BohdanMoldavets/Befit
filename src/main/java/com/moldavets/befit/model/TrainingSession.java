package com.moldavets.befit.model;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TrainingSession(
        Long id,

        @NotNull(message = "Start time is required")
        LocalDateTime startTime,

        @NotNull(message = "End time is required")
        LocalDateTime endTime
) {
}
