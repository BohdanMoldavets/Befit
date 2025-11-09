package com.moldavets.befit.mapper;

import com.moldavets.befit.model.TrainingSession;
import com.moldavets.befit.model.entity.TrainingSessionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrainingSessionMapper {

    TrainingSessionMapper INSTANCE = Mappers.getMapper(TrainingSessionMapper.class);

    TrainingSessionEntity map(TrainingSession trainingSession);
    TrainingSession map(TrainingSessionEntity trainingSession);

}
