package com.moldavets.befit.service;

import com.moldavets.befit.mapper.ExerciseTypeMapper;
import com.moldavets.befit.model.ExerciseType;
import com.moldavets.befit.repository.ExerciseTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseTypeService {

    private final ExerciseTypeRepository exerciseTypeRepository;

    public List<ExerciseType> findAll() {
        return exerciseTypeRepository.findAll()
                .stream()
                .map(ExerciseTypeMapper.INSTANCE::map)
                .toList();
    }

    public ExerciseType findById(Long id) {
        var storedEntity = exerciseTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("ExerciseType not found"));
        return ExerciseTypeMapper.INSTANCE.map(storedEntity);
    }

    @Transactional
    public ExerciseType save(ExerciseType exerciseType) {
        var storedEntity = exerciseTypeRepository.save(ExerciseTypeMapper.INSTANCE.map(exerciseType));
        return ExerciseTypeMapper.INSTANCE.map(storedEntity);
    }

    @Transactional
    public void deleteById(Long id) {
        exerciseTypeRepository.deleteById(id);
    }

}
