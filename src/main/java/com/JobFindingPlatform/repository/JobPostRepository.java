package com.JobFindingPlatform.repository;

import com.JobFindingPlatform.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobPostRepository extends JpaRepository<JobPost, Long> {
}
