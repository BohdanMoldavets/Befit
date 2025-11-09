package com.moldavets.befit.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EXERCISE_TYPE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseTypeEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    @Size(max = 50)
    private String name;

}
