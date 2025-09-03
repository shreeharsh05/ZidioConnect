package com.JobFindingPlatform.repository;

import com.JobFindingPlatform.ENUM.JobType;
import com.JobFindingPlatform.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByJobSeekerEmail(String jobSeekerEmail);

    List<Application> findByRecruiterEmail(String recruiterEmail);

    List<Application> findByJobType(JobType type);

    List<Application> findByJobTitle(String jobTitle);
}
