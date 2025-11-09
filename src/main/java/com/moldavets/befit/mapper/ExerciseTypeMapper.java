package com.moldavets.befit.mapper;

import com.moldavets.befit.model.ExerciseType;
import com.moldavets.befit.model.entity.ExerciseTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExerciseTypeMapper {

    ExerciseTypeMapper INSTANCE = Mappers.getMapper(ExerciseTypeMapper.class);

    ExerciseTypeEntity map(ExerciseType exerciseType);
    ExerciseType map(ExerciseTypeEntity exerciseType);

}
