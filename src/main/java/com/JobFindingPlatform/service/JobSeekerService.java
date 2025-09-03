package com.JobFindingPlatform.service;

import com.JobFindingPlatform.dto.JobSeekerDTO;
import com.JobFindingPlatform.entity.JobSeeker;
import com.JobFindingPlatform.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.OptionalInt;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO) {
        Optional<JobSeeker> existingJobSeeker = jobSeekerRepository.findByEmail(jobSeekerDTO.getEmail());
        if(existingJobSeeker.isPresent()) {
            throw new IllegalArgumentException("Job seeker already exists");
        }
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(jobSeekerDTO.getId());
        jobSeeker.setEmail(jobSeekerDTO.getEmail());
        jobSeeker.setPhone(jobSeekerDTO.getPhone());
        jobSeeker.setPassingYear(jobSeekerDTO.getPassingYear());
        jobSeeker.setResumeURL(jobSeekerDTO.getResumeURL());
        jobSeeker.setUniversityName(jobSeekerDTO.getUniversityName());
        jobSeeker.setActive(jobSeekerDTO.isActive());
        jobSeeker.setDegree(jobSeekerDTO.getDegree());

        JobSeeker saved = jobSeekerRepository.save(jobSeeker);

        return entityToDTO(saved);
    }

    public Optional<JobSeekerDTO> getJobSeekerByEmail(String email){
    Optional<JobSeeker> jobSeekerOpt=jobSeekerRepository.findByEmail(email);

     if(jobSeekerOpt.isPresent()){
         JobSeekerDTO dto = entityToDTO(jobSeekerOpt.get());
         return Optional.of(dto) ;
     }else{
         return  Optional.empty();
     }

    }


    public Optional<JobSeekerDTO> getJobSeekerById(long id){
        Optional<JobSeeker> jobSeekerOpt=jobSeekerRepository.findById(id);

        if(jobSeekerOpt.isPresent()){
            JobSeekerDTO dto = entityToDTO(jobSeekerOpt.get());
            return Optional.of(dto) ;
        }else{
            return  Optional.empty();
        }

    }




    private JobSeekerDTO entityToDTO(JobSeeker dto) {

        JobSeekerDTO jobSeekerDTO = new JobSeekerDTO();

        jobSeekerDTO.setId(dto.getId());
        jobSeekerDTO.setEmail(dto.getEmail());
        jobSeekerDTO.setPhone(dto.getPhone());
        jobSeekerDTO.setPassingYear(dto.getPassingYear());
        jobSeekerDTO.setResumeURL(dto.getResumeURL());
        jobSeekerDTO.setUniversityName(dto.getUniversityName());
        jobSeekerDTO.setActive(dto.isActive());
        jobSeekerDTO.setDegree(dto.getDegree());

        return jobSeekerDTO;
    }

}
