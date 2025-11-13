package com.moldavets.befit.service;

import com.moldavets.befit.mapper.ExerciseTypeMapper;
import com.moldavets.befit.mapper.TrainingExerciseMapper;
import com.moldavets.befit.mapper.TrainingSessionMapper;
import com.moldavets.befit.model.TrainingExercise;
import com.moldavets.befit.repository.TrainingExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingExerciseService {

    private final TrainingExerciseRepository trainingExerciseRepository;
    private final ExerciseTypeService exerciseTypeService;
    private final TrainingSessionService trainingSessionService;

    public List<TrainingExercise> findAll() {
        return trainingExerciseRepository.findAll()
                .stream()
                .map(TrainingExerciseMapper.INSTANCE::map)
                .toList();
    }

    public TrainingExercise findById(Long id) {
        var storedEntity = trainingExerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TrainingExercise not found"));
        return TrainingExerciseMapper.INSTANCE.map(storedEntity);
    }

    public TrainingExercise save(TrainingExercise exercise) {
        var trainingSession = trainingSessionService.findById(exercise.getTrainingSessionId());
        var exerciseType = exerciseTypeService.findById(exercise.getExerciseTypeId());
        var trainingExerciseEntity = TrainingExerciseMapper.INSTANCE.map(exercise);
        trainingExerciseEntity.setExerciseType(ExerciseTypeMapper.INSTANCE.map(exerciseType));
        trainingExerciseEntity.setTrainingSession(TrainingSessionMapper.INSTANCE.map(trainingSession));
        var storedEntity = trainingExerciseRepository.save(trainingExerciseEntity);
        return TrainingExerciseMapper.INSTANCE.map(storedEntity);
    }

    public void deleteById(Long id) {
        trainingExerciseRepository.deleteById(id);
    }

}
