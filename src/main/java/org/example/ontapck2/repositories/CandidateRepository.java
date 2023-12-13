package org.example.ontapck2.repositories;

import org.example.ontapck2.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c JOIN c.experiences e WHERE e.company = :company")
    List<Candidate> findCandidatesByCompany(@Param("company") String company);
}
