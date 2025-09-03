package com.JobFindingPlatform.controller;


import com.JobFindingPlatform.dto.RecruiterDTO;
import com.JobFindingPlatform.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recruiters")

public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<RecruiterDTO> createRecruiter(@RequestBody RecruiterDTO recruiterDto){
        RecruiterDTO dto= recruiterService.createRecruiterProfile(recruiterDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<RecruiterDTO>> getRecruiterByEmail(@PathVariable String email){
        return ResponseEntity.ok(recruiterService.getRecruiterByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RecruiterDTO>> getRecruiterById(@PathVariable Long id){
        return ResponseEntity.ok(recruiterService.getRecruiterById(id));
    }
}
