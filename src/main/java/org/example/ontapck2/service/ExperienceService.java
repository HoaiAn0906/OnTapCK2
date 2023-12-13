package org.example.ontapck2.service;

import lombok.AllArgsConstructor;
import org.example.ontapck2.models.Experience;
import org.example.ontapck2.repositories.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public List<Experience> getExperienceByCandidateId(Long canId) {
        return experienceRepository.findByCanId(canId);
    }
}
