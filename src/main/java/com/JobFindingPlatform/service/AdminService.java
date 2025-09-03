package com.JobFindingPlatform.service;

import com.JobFindingPlatform.ENUM.Action;
import com.JobFindingPlatform.dto.AdminDTO;
import com.JobFindingPlatform.entity.Admin;
import com.JobFindingPlatform.entity.User;
import com.JobFindingPlatform.repository.AdminRepository;
import com.JobFindingPlatform.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminService {


    private final AdminRepository adminRepository;
    private final UserRespository userRespository;


    public Admin performanceAction(AdminDTO adminDTO){
        User user = userRespository.findById(adminDTO.getUserId())
                .orElseThrow( () -> new RuntimeException("user not found") );

        if(adminDTO.getAction() == Action.BLOCK){
            user.setBlocked(true);
        }else if(adminDTO.getAction() == Action.UNBLOCK){
            user.setBlocked(false);
        }
        userRespository.save(user);
        Admin admin = new Admin();

        admin.setId(adminDTO.getId());
        admin.setUsername(adminDTO.getUsername());
        admin.setAction(adminDTO.getAction());
        admin.setAdminId(adminDTO.getAdminId());
        admin.setCreatedAt(adminDTO.getCreatedAt());

        return adminRepository.save(admin);
    }


    public List<Admin> getActionsByAdmin(Long id){
        return adminRepository.findByAdminId(id);
    }


    public List<Admin> getActionsByUser(Long userId) {
        return adminRepository.findByUserId(userId);
    }
}
