package org.example.ontapck2.repositories;

import org.example.ontapck2.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
//    @Query("SELECT e from Experience e WHERE e.candidate.canId = :canId")
//    List<Experience> findByCanId(@Param("canId") Long canId);
    @Query(value = "SELECT * FROM experiences WHERE can_id = :canId", nativeQuery = true)
    List<Experience> findByCanId(@Param("canId") Long canId);
}
