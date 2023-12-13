package org.example.ontapck2.repositories;

import org.example.ontapck2.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByCandidate_CanId(Long canId);
}
