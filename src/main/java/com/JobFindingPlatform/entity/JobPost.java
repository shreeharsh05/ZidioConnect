package com.JobFindingPlatform.entity;


import com.JobFindingPlatform.ENUM.JobType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="jobPosts")
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue
    private Long id;

    private String jobTitle;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    private String jobLocation;
    private String remote;
    private String companyName;
    private String jobCatogory;
    private String jobDescription;
    private String postedBy;
    private LocalDateTime postedAt;
    private boolean active = true;
}
