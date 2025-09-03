package com.JobFindingPlatform.dto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import com.JobFindingPlatform.ENUM.JobType;
import com.JobFindingPlatform.ENUM.ApplicationStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationsDTO{
    
    private Long id;
    private String jobSeekerName;
    private String jobSeekerEmail;
    private Long jobId;
    private String jobTitle;
    private JobType jobType;
    private String recruiterEmail;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;

}