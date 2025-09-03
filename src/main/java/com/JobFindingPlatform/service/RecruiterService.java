package com.JobFindingPlatform.service;


import com.JobFindingPlatform.dto.RecruiterDTO;
import com.JobFindingPlatform.entity.Recruiter;
import com.JobFindingPlatform.repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.JobFindingPlatform.entity.Recruiter;
import com.JobFindingPlatform.repository.RecruiterRepository;
import com.JobFindingPlatform.dto.RecruiterDTO;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterDTO createRecruiterProfile(RecruiterDTO recruiterDTO) {

        Optional<Recruiter> existingRecruiter = recruiterRepository.findByRecruiterEmail(recruiterDTO.getRecruiterEmail());
        if(existingRecruiter.isPresent()) {
            throw new IllegalArgumentException("Recruiter already exists");
        }
        Recruiter recruiter = new Recruiter();
        recruiter.setRecruiterEmail(recruiterDTO.getRecruiterEmail());
        recruiter.setRecruiterName(recruiterDTO.getRecruiterName());
        recruiter.setCompanyName(recruiterDTO.getCompanyName());
        recruiter.setRecruiterPhone(recruiterDTO.getRecruiterPhone());
        recruiter.setDesignation(recruiterDTO.getDesignation());


        Recruiter saved = recruiterRepository.save(recruiter);

        return  entityToDTO(saved);

    }

    public RecruiterDTO entityToDTO(Recruiter recruiter) {
        RecruiterDTO recruiterDTO = new RecruiterDTO();

        recruiterDTO.setId(recruiter.getId());
        recruiterDTO.setRecruiterEmail(recruiter.getRecruiterEmail());
        recruiterDTO.setRecruiterName(recruiter.getRecruiterName());
        recruiterDTO.setCompanyName(recruiter.getCompanyName());
        recruiterDTO.setRecruiterPhone(recruiter.getRecruiterPhone());
        recruiterDTO.setDesignation(recruiter.getDesignation());

        return recruiterDTO;
    }

    public Optional<RecruiterDTO> getRecruiterByEmail(String email){
        Optional<Recruiter> recruiterOpt = recruiterRepository.findByRecruiterEmail(email);
        if(recruiterOpt.isPresent()){
            RecruiterDTO dto= entityToDTO(recruiterOpt.get());
            return Optional.of(dto);
        }else{
            return Optional.empty();
        }
    }

    public Optional<RecruiterDTO> getRecruiterById(Long id){
        Optional<Recruiter> recruiterOpt = recruiterRepository.findById(id);
        if(recruiterOpt.isPresent()){
            RecruiterDTO dto= entityToDTO(recruiterOpt.get());
            return Optional.of(dto);
        }else{
            return Optional.empty();
        }
    }

}
