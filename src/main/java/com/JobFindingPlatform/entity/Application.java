package com.JobFindingPlatform.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import com.JobFindingPlatform.ENUM.JobType;
import com.JobFindingPlatform.ENUM.ApplicationStatus;

@Entity
@Table(name="applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobSeekerName;
    @Column(unique=true)
    private String jobSeekerEmail;
    private Long jobId;
    private String jobTitle;
    private JobType jobType;
    @Column(unique = true)
    private String recruiterEmail;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private LocalDateTime appliedAt;

  
    
}