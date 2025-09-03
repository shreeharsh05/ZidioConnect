package com.JobFindingPlatform.dto;


import com.JobFindingPlatform.ENUM.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPostDTO {

    private Long id;
    private String jobTitle;
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
