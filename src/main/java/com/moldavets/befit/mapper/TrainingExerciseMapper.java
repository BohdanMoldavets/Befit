package com.moldavets.befit.mapper;

import com.moldavets.befit.model.TrainingExercise;
import com.moldavets.befit.model.entity.TrainingExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainingExerciseMapper {

    TrainingExerciseMapper INSTANCE = Mappers.getMapper(TrainingExerciseMapper.class);

    TrainingExercise map(TrainingExerciseEntity trainingExerciseEntity);
    TrainingExerciseEntity map(TrainingExercise trainingExercise);

}
