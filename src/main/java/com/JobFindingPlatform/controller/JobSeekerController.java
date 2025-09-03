package com.JobFindingPlatform.controller;

import com.JobFindingPlatform.dto.JobSeekerDTO;
import com.JobFindingPlatform.service.JobSeekerService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/create")
    public ResponseEntity<JobSeekerDTO> createJobSeekers(@RequestBody JobSeekerDTO jobSeekerDTO){
        return ResponseEntity.ok(jobSeekerService.createJobSeeker(jobSeekerDTO));
    }
    @GetMapping("/test")
    public ResponseEntity<String> test(String hello){
        return ResponseEntity.ok("HEllo "+hello);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<JobSeekerDTO>> getJobSeekerByEmail(@PathVariable  String email){
        return ResponseEntity.ok(jobSeekerService.getJobSeekerByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<JobSeekerDTO>> getJobSeekerByid(@PathVariable Long id){
        return ResponseEntity.ok(jobSeekerService.getJobSeekerById(id));
    }


}
