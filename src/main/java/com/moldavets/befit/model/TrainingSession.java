package com.moldavets.befit.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainingSession {

    Long id;

    @NotBlank(message = "Name time is required")
    String name;

    @NotNull(message = "Start time is required")
    LocalDateTime startTime;

    @NotNull(message = "End time is required")
    LocalDateTime endTime;

}
