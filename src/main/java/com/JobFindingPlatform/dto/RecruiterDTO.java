package com.JobFindingPlatform.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruiterDTO {

    private Long id;
    private String recruiterName;
    private String recruiterEmail;
    private String recruiterPhone;
    private String companyName;
    private String designation;
}
