package com.JobFindingPlatform.controller;

import com.JobFindingPlatform.ENUM.JobType;
import com.JobFindingPlatform.dto.JobPostDTO;
import com.JobFindingPlatform.service.JobPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPost/")
public class JobPostController {
    @Autowired
    private  JobPostService jobPostService;

    @PostMapping
    public ResponseEntity<String> createJobPost(@RequestBody JobPostDTO dto) {
        return ResponseEntity.ok(jobPostService.createJobPost(dto));
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobPostDTO>> searchJobPost(
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String JobTitle,
            @RequestParam(required = false) JobType jobType,
            @RequestParam(required = false) String jobLocation,
            @RequestParam(required = false) String remote
            ) {
        return ResponseEntity.ok(jobPostService.getAllJobPosts(companyName, JobTitle, jobType, jobLocation, remote));
    }

    @PostMapping("/close/{id}")
    public ResponseEntity<String> closeJobPost(@PathVariable Long id) {
        jobPostService.closeJobPost(id);
        return ResponseEntity.ok("Job post closed");
    }
}
