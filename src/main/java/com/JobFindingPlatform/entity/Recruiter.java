package com.JobFindingPlatform.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {


        @Id
        @GeneratedValue
        private Long id;
        private String recruiterName;
        @Column(unique = true)
        private String recruiterEmail;
        private String recruiterPhone;
        private String companyName;
        private String designation;


}
