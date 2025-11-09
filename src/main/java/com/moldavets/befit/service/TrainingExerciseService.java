package com.moldavets.befit.service;

import com.moldavets.befit.mapper.TrainingExerciseMapper;
import com.moldavets.befit.model.TrainingExercise;
import com.moldavets.befit.repository.TrainingExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingExerciseService {

    private final TrainingExerciseRepository trainingExerciseRepository;

    public List<TrainingExercise> findAll() {
        return trainingExerciseRepository.findAll()
                .stream()
                .map(TrainingExerciseMapper.INSTANCE::map)
                .toList();
    }

    public TrainingExercise findById(Long id) {
        var storedEntity = trainingExerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("TrainingExercise not found"));
        return TrainingExerciseMapper.INSTANCE.map(storedEntity);
    }

    public TrainingExercise save(TrainingExercise exercise) {
        var storedEntity = trainingExerciseRepository.save(TrainingExerciseMapper.INSTANCE.map(exercise));
        return TrainingExerciseMapper.INSTANCE.map(storedEntity);
    }

    public void deleteById(Long id) {
        trainingExerciseRepository.deleteById(id);
    }

}
