package org.example.ontapck2.service;

import lombok.AllArgsConstructor;
import org.example.ontapck2.models.Candidate;
import org.example.ontapck2.models.Experience;
import org.example.ontapck2.repositories.CandidateRepository;
import org.example.ontapck2.repositories.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final ExperienceRepository experienceRepository;

    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    public List<Candidate> getCandidateByCompany(String company) {
        return candidateRepository.findCandidatesByCompany(company);
    }

    public List<Candidate> getCandidateGT5Experience() {
        return candidateRepository.findCandidatesWithAtLeastFiveYearsExperience();
    }
}
