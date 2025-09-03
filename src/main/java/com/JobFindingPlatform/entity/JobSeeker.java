package com.JobFindingPlatform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String phone;
    private String colleageName;
    private String universityName;
    private String degree;
    private LocalDate passingYear;
    private String resumeURL;
    private boolean active;

}
