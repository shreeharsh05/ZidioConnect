package com.JobFindingPlatform.service;

import com.JobFindingPlatform.ENUM.ApplicationStatus;
import com.JobFindingPlatform.ENUM.JobType;
import com.JobFindingPlatform.entity.Application;
import com.JobFindingPlatform.dto.ApplicationsDTO;
import com.JobFindingPlatform.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService{
    private final ApplicationRepository applicationRepository;

    public String apply(ApplicationsDTO dto){
        Application app = new Application();

        app.setJobId(dto.getJobId());
		app.setJobSeekerName(dto.getJobSeekerName());
		app.setJobSeekerEmail(dto.getJobSeekerEmail());
		app.setJobTitle(dto.getJobTitle());
		app.setJobType(dto.getJobType());
		app.setRecruiterEmail(dto.getRecruiterEmail());
		app.setStatus(dto.getStatus());
		app.setAppliedAt(dto.getAppliedAt());
		
		applicationRepository.save(app);
        return "Applied Successfully";
    }

    public List<ApplicationsDTO> getApplicationsByJobSeekerEmail(String email) {
        return applicationRepository.findByJobSeekerEmail(email).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationsDTO> getRecruiterEmail(String email) {
        return applicationRepository.findByRecruiterEmail(email).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()); // Java 16+, else use .collect(Collectors.toList())
    }

    public List<ApplicationsDTO> getJobTitle(String title) {
        return applicationRepository.findByJobTitle(title).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationsDTO> getJobType(String type) {
        return applicationRepository.findByJobType(JobType.valueOf(type.toUpperCase())).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public void updateApplicationStatus(Long applicationId, ApplicationStatus status) {
        Application app = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + applicationId));

        app.setStatus(status);
        applicationRepository.save(app);
    }



    private ApplicationsDTO mapToDTO(Application app) {
		
		ApplicationsDTO dto = new ApplicationsDTO();
		dto.setJobId(app.getJobId());
		dto.setJobSeekerEmail(app.getJobSeekerEmail());
		dto.setJobSeekerName(app.getJobSeekerName());
		dto.setRecruiterEmail(app.getRecruiterEmail());
		dto.setJobType(app.getJobType());
		dto.setJobTitle(app.getJobTitle());
		dto.setAppliedAt(app.getAppliedAt());
		dto.setStatus(app.getStatus());
		
		return dto;
	}
    

}