package com.JobFindingPlatform.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobSeekerDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String collegeName;
    private String universityName;
    private String degree;
    private LocalDate passingYear;
    private String resumeURL;
    private boolean active;
}
