package com.JobFindingPlatform.repository;


import com.JobFindingPlatform.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Optional<Recruiter> findByRecruiterEmail(String recruiterEmail);
}
