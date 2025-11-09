package com.moldavets.befit.service;

import com.moldavets.befit.mapper.TrainingSessionMapper;
import com.moldavets.befit.model.TrainingSession;
import com.moldavets.befit.repository.TrainingSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    public List<TrainingSession> findAll() {
        return trainingSessionRepository.findAll().stream()
                .map(TrainingSessionMapper.INSTANCE::map)
                .toList();
    }

    public TrainingSession findById(Long id) {
        var storedEntity = trainingSessionRepository.findById(id).orElseThrow(() -> new RuntimeException("TrainingSession not found"));
        return TrainingSessionMapper.INSTANCE.map(storedEntity);
    }

    public TrainingSession save(TrainingSession session) {
        var storedEntity = trainingSessionRepository.save(TrainingSessionMapper.INSTANCE.map(session));
        return TrainingSessionMapper.INSTANCE.map(storedEntity);
    }

    public void deleteById(Long id) {
        trainingSessionRepository.deleteById(id);
    }

}
