package com.JobFindingPlatform.service;

import com.JobFindingPlatform.ENUM.JobType;
import com.JobFindingPlatform.dto.JobPostDTO;
import com.JobFindingPlatform.entity.JobPost;
import com.JobFindingPlatform.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostService {
    @Autowired
    private JobPostRepository jobPostRepository;

    public String createJobPost(JobPostDTO dto) {
        JobPost job = new JobPost();

        job.setCompanyName(dto.getCompanyName());
        job.setJobType(dto.getJobType());
        job.setJobCatogory(dto.getJobCatogory());
        job.setJobDescription(dto.getJobDescription());
        job.setJobLocation(dto.getJobLocation());
        job.setJobTitle(dto.getJobTitle());
        job.setPostedBy(dto.getPostedBy());
        job.setRemote(dto.getRemote());
        job.setPostedAt(dto.getPostedAt());


        jobPostRepository.save(job);

        return "Job got Posted";
    }


    public List<JobPostDTO> getAllJobPosts(String companyName, String jobTitle, JobType jobType,String jobLocation,String remote) {

        return jobPostRepository.findAll().stream()
                .filter(job -> companyName == null || job.getCompanyName().equalsIgnoreCase(companyName))
                .filter(job -> jobTitle == null || job.getJobTitle().equalsIgnoreCase(jobTitle))
                .filter(job -> jobType == null || job.getJobType().equals(jobType))
                .filter(job -> jobLocation == null || job.getJobLocation().equalsIgnoreCase(remote))
                .filter(job -> remote == null || job.getRemote().equalsIgnoreCase(remote))
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    public void  closeJobPost(Long jobPostId) {
        JobPost jobPost = jobPostRepository.findById(jobPostId).orElseThrow(()-> new RuntimeException("Job Post Not Found"));
        jobPost.setActive(false);
        jobPostRepository.save(jobPost);
    }

    private JobPostDTO mapToDTO(JobPost jobPost) {
        JobPostDTO dto = new JobPostDTO();
        dto.setId(jobPost.getId());
        dto.setJobTitle(jobPost.getJobTitle());
        dto.setJobType(jobPost.getJobType());
        dto.setJobLocation(jobPost.getJobLocation());
        dto.setRemote(jobPost.getRemote());
        dto.setCompanyName(jobPost.getCompanyName());
        dto.setJobCatogory(jobPost.getJobCatogory());
        dto.setJobDescription(jobPost.getJobDescription());
        dto.setPostedBy(jobPost.getPostedBy());
        dto.setPostedAt(jobPost.getPostedAt());
        dto.setActive(jobPost.isActive());
        return dto;
    }




}
